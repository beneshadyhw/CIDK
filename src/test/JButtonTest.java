package test;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * 1:��ť��Swing���ǽ�Ϊ��������������ڴ����ض�����
 * Swing���ṩ�˶��ְ�ť�������ύ��ť����ѡ�򣬵�ѡ��ť��
 * ��Щ��ť���Ǵ�AbstractButton���м̳ж�����
 * 
 * 2:Swing�е��ύ��ť���(JButton)��JButton�����ʾ
 * JButton����4����Ҫ�Ĺ��췽��
 * ����text,icon�ֱ������ʾ���ֱ�ǩ��ͼ��
 * 
 * 3:��ʵ��ʹ�������ַ�ʽ������ť����һ�����ڳ�ʼ����ťʱ���谴ťͼ��������
 * ���ֳ�ʼ�������Ȼ��ͼƬ·����Ȼ��·��ʵ������Icon��Ȼ����Button�м��س���
 * �ڶ��ַ�ʽ�����ȴ���һ��û�ж���ͼ������ֵİ�ť����Ȼ��ʹ��
 * setIcon()����Ϊ�����ť����һ��ͼ�ꡣ
 * setToolTipText()������Ϊ��ť������ʾ���֣����ͣ���ڰ�ť���漴��
 * setBorderPainted()�������ñ߽��Ƿ���ʾ
 * setMaximumSize()�������ð�ť�Ĵ�С��ͼ��Ĵ�Сһ�£����෽����Ҫ�Ĳ���������
 *           Dimension�������������ȥ��ͼƬ����ͬ��ťһ���ڷ��ڴ����У�
 *           ͬʱҲ����ʹ��setEnabled()�������ð�ť�Ƿ����
 * 
 * @author biexiansheng
 *
 */
public class JButtonTest extends JFrame{

    public JButtonTest(){//����һ�����췽��
        //��ȡͼƬ���ڵ�URL    ����2�д�����Ҫ����ע��
        URL url=JButtonTest.class.getResource("imageButtoo.jpg");
        Icon icon=new ImageIcon(url);//ʵ����Icon����
        
        //�������񲼾ֹ�����   3��2��  ˮƽ5��ֱ5
        setLayout(new GridLayout(3,2,5,5));
        
        //��������
        Container container=getContentPane();
        for(int i=0;i<5;i++){//������ť��ͬʱ���ð�ť���ֺ�ͼ��
            JButton jb=new JButton("button"+i,icon);
            container.add(jb);//����ť���ӵ�������
            if(i%2==0){
                jb.setEnabled(false);//��������һЩ��ť������
            }
        }//����λ���ְ�ť��ʵ����
        
        JButton jb2=new JButton();//ʵ����һ��û��������ͼƬ�İ�ť
        jb2.setMaximumSize(new Dimension(90,30));//���ð�ť��ͼƬ�Ĵ�С��ͬ
        jb2.setIcon(icon);//Ϊ��ť����ͼ��
        jb2.setHideActionText(true);
        jb2.setToolTipText("ͼƬ��ť");//���ð�ť��ʾΪ����
        jb2.setBorderPainted(false);//���ð�ť�߽粻��ʾ
        jb2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //�����Ի���
                JOptionPane.showMessageDialog(null, "�����Ի���");
            }
        });
        container.add(jb2);//����ť���ӵ�������
        
        setTitle("�ύ��ť�����ťС��ţ��");//���ô��ڱ���
        setVisible(true);//���ô��ڿ��ӻ�
        setSize(500,550);//���ô��ڵĴ�С
        //���ô��ڵĹرշ�ʽ
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JButtonTest jb=new JButtonTest();
    }

}