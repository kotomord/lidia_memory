package org.lidochka.branchandbound.codegeneration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kotomord on 25.10.2016.
 */
public class BABGenerator {

    public static void main(String[] args) throws FileNotFoundException {
        for(int i = 4; i<12; ++i)
            generateBABMethod(i);
    }

    private static  final String packageWay = "src/main/java/org/lidochka/branchandbound/";

    private static void generateBABMethod(int size) throws FileNotFoundException {
        String classname = "BABMethod_" + size;
        PrintStream ps = new PrintStream(new FileOutputStream(new File( packageWay + classname +".java")));
        ps.println("package org.lidochka.branchandbound;");

        ps.println("//auto-generated and just formatted");

        ps.println("class " + classname + " implements BABMethod{");
        ps.println();
        ps.println("static{\n BABGate.methods[" + size + "] = new " + classname + "();\n}");
        ps.println();

        ps.println("public boolean hasOneAuthomorphism(final int[][] matrix){");
        ps.println("BoolStore store = new BoolStore();");
        ps.print("runFixed0(matrix, store");
        for(int i = 0; i< size; ++i) ps.print(", " + i);
        ps.println(");\n return store.state;\n}");
        ps.println();

        for(int i = 0; i<=size; ++i)
             generateFixedMethod(ps, i, size);


        ps.println("}");
        ps.flush();
        ps.close();
    }

    private static void generateFixedMethod(PrintStream ps, int fixed, int size) {
        ps.println("private void runFixed" + fixed + "(final  int[][] matrix, final BoolStore store ");
        for(int i = 0; i< size; ++i)
            ps.print(", final int x"+i);
        ps.println("){");
        ps.println("if(store.state) return;");

        if(fixed > 0){
            int pos = fixed - 1;
            ps.printf("if (x%d == %d) return;\n", pos, pos);
            for(int i = 0; i<fixed; ++i){
                ps.printf("if(matrix[%d][%d] != matrix[x%d][x%d]) return;\n", i, pos, i, pos );
            }
        }

        if(fixed < size){
            String startCall = "runFixed" + (fixed+1) + "(matrix, store";
            for(int i = 0; i<fixed; ++i)
                startCall += ", x"+i;
            List<Integer> ls = new ArrayList<>();
            for(int i = fixed; i<size; ++i) ls.add(i);
            for(Integer i: ls){
                ps.print(startCall + ", x" +i);
                for(Integer j: ls)
                    if(i.intValue() != j.intValue())
                        ps.print(", x" +j);
                ps.println(");");
            }

        }else{
            ps.println("store.state = true;");
        }

        ps.println("}");
        ps.println();
    }

}
