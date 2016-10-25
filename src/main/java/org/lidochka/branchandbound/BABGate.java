package org.lidochka.branchandbound;

/**
 * Created by kotomord on 25.10.2016.
 */
public class BABGate {
    static  BABMethod[] methods = new BABMethod[12];
    static {
          try{
              for(int i =4; i<12; ++i)
                  Class.forName("org.lidochka.branchandbound.BABMethod_" +i);
          }catch (Exception ex){
              throw new RuntimeException("ClassLoader hack failed",ex);
          }
    }

    public static  boolean  hasOneAuthomorphism(final int[][] matrix){
        return  methods[matrix.length].hasOneAuthomorphism(matrix);
    }

}
