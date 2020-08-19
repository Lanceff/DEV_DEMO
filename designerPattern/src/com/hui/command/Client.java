package com.hui.command;

/**
 * @author: Lance
 * @Date: 2020-08-05 09:26
 * @Description: 1) Invoker �ǵ����߽�ɫ
 * 2) Command: �������ɫ����Ҫִ�е������������������ǽӿڻ������
 * 3) Receiver: �����߽�ɫ��֪�����ʵʩ��ִ��һ��������صĲ���
 * 4) ConcreteCommand: ��һ�������߶�����һ�������󶨣����ý�������Ӧ�Ĳ�����ʵ�� execute
 */
public class Client {

    public static void main(String[] args) {
        //ʹ���������ģʽ�����ͨ��ң�������Ե�ƵĲ���

        //������ƵĶ���(������)
        LightReceiver lightReceiver = new LightReceiver();
        //���������صĿ�������
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        //��Ҫһ��ң����
        RemoteController remoteController = new RemoteController();

        //�����ǵ�ң������������, ���� no = 0 �ǵ�ƵĿ��͹صĲ���
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.println("--------���µƵĿ���ť-----------");
        remoteController.onButtonWasPushed(0);
        System.out.println("--------���µƵĹذ�ť-----------");
        remoteController.offButtonWasPushed(0);
        System.out.println("--------���³�����ť-----------");
        remoteController.undoButtonWasPushed();


        System.out.println("=========ʹ��ң�����������ӻ�==========");

        TvReceiver tvReceiver = new TvReceiver();

        TvOffCommand tvOffCommand = new TvOffCommand(tvReceiver);
        TvOnCommand tvOnCommand = new TvOnCommand(tvReceiver);

        //�����ǵ�ң������������, ���� no = 1 �ǵ��ӻ��Ŀ��͹صĲ���
        remoteController.setCommand(1, tvOnCommand, tvOffCommand);

        System.out.println("--------���µ��ӻ��Ŀ���ť-----------");
        remoteController.onButtonWasPushed(1);
        System.out.println("--------���µ��ӻ��Ĺذ�ť-----------");
        remoteController.offButtonWasPushed(1);
        System.out.println("--------���³�����ť-----------");
        remoteController.undoButtonWasPushed();

    }
}
