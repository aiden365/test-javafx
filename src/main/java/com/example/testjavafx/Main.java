package com.example.testjavafx;

/**
 * 必须使用不包含Application的启动类，来启动Application的子类，否则将会提示“错误: 缺少 javafx 运行时组件”
 */
public class Main {

    public static void main(String [] args) {
        HelloApplication.main(args);
    }
}
