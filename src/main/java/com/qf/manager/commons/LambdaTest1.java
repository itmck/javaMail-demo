package com.qf.manager.commons;

/**
 * Create by it_mck 2018/10/15 13:50
 *
 * @Description: lambda 表达式
 * @Version: 1.0
 */
public class LambdaTest1 {
    public static void main(String[] args) {
        //传统内部类的实现
        LambdaUse((s)->System.out.println(s),"hello world");
    }
    public static void LambdaUse(ILambdaTest1 lambda,String string){
        lambda.print(string);
    }

}

interface ILambdaTest1{
    void print(String s);
}
