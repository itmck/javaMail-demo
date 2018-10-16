package com.qf.manager.commons;

/**
 * Create by it_mck 2018/10/15 13:55
 *
 * @Description:
 * @Version: 1.0
 */
public class LambdaTest2 {

    public static void main(String[] args) {

        int i = LambdaUse(new ILambdaTest2() {
            @Override
            public int print(int a, int b) {
                return a + b;
            }
        }, 34, 26);

        System.out.println(i);


    }

    public static int LambdaUse(ILambdaTest2 lambda,int a ,int b){
        return a>b?a:b;
    }

}


interface ILambdaTest2{
    int  print(int a,int b);
}

