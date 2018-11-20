import org.antlr.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;
import  org.antlr.v4.runtime.CharStream;
import  org.antlr.v4.runtime.CommonTokenStream;
import  org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import static org.antlr.v4.runtime.CharStreams.fromFileName;


public class Launch{



    public  static  void main(String[] args){
        try{
          //  ANTLRErrorListener error = new BaseErrorListener();
            String source="test.txt";

            CharStream cs=fromFileName(source);
           // ANTLRInputStream input = new ANTLRInputStream(System.in);
            gLexer lexer =new gLexer( cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            gParser parser = new gParser(token);

            lexer.removeErrorListeners();
            lexer.addErrorListener(myerrorlistener.INSTANCE);
            parser.removeErrorListeners();
            parser.addErrorListener(myerrorlistener.INSTANCE);

            ParseTree tree = parser.program();
            myvisitor visitor = new myvisitor();
            visitor.visit(tree);
//            System.out.println( myerrorlistener.INSTANCE.toString());



            /*
            lexer.removeErrorListeners();
            lexer.addErrorListener(myerrorlistener.INSTANCE);
            parser.removeErrorListeners();
            parser.addErrorListener(myerrorlistener.INSTANCE);
*/

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}