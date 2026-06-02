import java.awt.geom.Point2D;
import java.io.File;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.editor.BasicModelEditor;
import com.change_vision.jude.api.inf.editor.ClassDiagramEditor;
import com.change_vision.jude.api.inf.editor.ModelEditorFactory;
import com.change_vision.jude.api.inf.editor.TransactionManager;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IGeneralization;
import com.change_vision.jude.api.inf.model.IModel;
import com.change_vision.jude.api.inf.model.IPackage;
import com.change_vision.jude.api.inf.presentation.INodePresentation;
import com.change_vision.jude.api.inf.project.ProjectAccessor;

public class CreateExceptionDiagram {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("Usage: CreateExceptionDiagram <output.asta>");
        }

        String outputPath = new File(args[0]).getAbsolutePath();
        ProjectAccessor accessor = AstahAPI.getAstahAPI().getProjectAccessor();

        accessor.create(outputPath);
        IModel project = accessor.getProject();

        TransactionManager.beginTransaction();
        try {
            BasicModelEditor modelEditor = ModelEditorFactory.getBasicModelEditor();
            IPackage exceptionPackage = modelEditor.createPackage(project, "hust.soict.hedspi.aims.exception");

            IClass exceptionClass = modelEditor.createClass(exceptionPackage, "Exception");
            exceptionClass.setDefinition("java.lang.Exception");

            IClass playerException = modelEditor.createClass(exceptionPackage, "PlayerException");
            playerException.setDefinition("Self-defined exception thrown when playable media cannot be played.");

            IClass limitExceededException = modelEditor.createClass(exceptionPackage, "LimitExceededException");
            limitExceededException.setDefinition("Self-defined exception thrown when the cart item limit is exceeded.");

            IGeneralization playerToException =
                    modelEditor.createGeneralization(playerException, exceptionClass, "");
            IGeneralization limitToException =
                    modelEditor.createGeneralization(limitExceededException, exceptionClass, "");

            ClassDiagramEditor diagramEditor = accessor.getDiagramEditorFactory().getClassDiagramEditor();
            diagramEditor.createClassDiagram(exceptionPackage, "Exception hierarchical tree");

            INodePresentation exceptionNode =
                    diagramEditor.createNodePresentation(exceptionClass, new Point2D.Double(240.0d, 40.0d));
            INodePresentation playerNode =
                    diagramEditor.createNodePresentation(playerException, new Point2D.Double(60.0d, 220.0d));
            INodePresentation limitNode =
                    diagramEditor.createNodePresentation(limitExceededException, new Point2D.Double(380.0d, 220.0d));

            diagramEditor.createLinkPresentation(playerToException, exceptionNode, playerNode);
            diagramEditor.createLinkPresentation(limitToException, exceptionNode, limitNode);

            TransactionManager.endTransaction();
        } catch (Throwable e) {
            TransactionManager.abortTransaction();
            throw e;
        }

        accessor.save();
        accessor.close();
    }
}
