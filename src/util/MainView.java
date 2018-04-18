package util;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class MainView extends JFrame {

 /**
	 * 
	 */
	private static final long serialVersionUID = -566108802440902886L;
private JPanel contentPane;
 private JTextField accountName;
 private JTextField userName;
 private JTextField projectID;
 private JTextField imageID;
 private JTextField imageName;
 private JTextField passwordField; 
 
 private String accountNameContent;
 private String userNameContent;
 private String projectIDContent;
 private String passwordContent;
 private String imageIDContent;
 private String imageNameContent;
 private String tokenContent;
 
 private final Action action_1 = new DuplicateImage();
 private final Action action_2 = new ClearAction();
 

 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     MainView frame = new MainView();
     frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the frame.
  */
 public MainView() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 437, 543);
  setTitle("Huawei Cloud IMG Duplicating Kit v1.0");
//  setSize(510, 520);
  contentPane = new JPanel();
  contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(255, 0, 0)), "\u534E\u4E3A\u4E91\u955C\u50CF\u590D\u5236\u5C0F\u5DE5\u5177", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  JLabel lblNewLabel = new JLabel("\u534E\u4E3A\u4E91\u8D26\u53F7\u540D\uFF1A");
  lblNewLabel.setForeground(new Color(0, 0, 0));
  lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
  lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
  lblNewLabel.setBounds(5, 28, 141, 26);
  contentPane.add(lblNewLabel);
  
  accountName = new JTextField();
  accountName.setToolTipText("\u7528\u6237\u6240\u5C5E\u4F01\u4E1A\u8D26\u6237\u540D\u79F0");
  accountName.setBounds(156, 31, 232, 21);
  contentPane.add(accountName);
  accountName.setColumns(10);
  
  userName = new JTextField();
  userName.setToolTipText("\u7528\u6237\uFF08\u5B50\u7528\u6237\uFF09\u540D\u79F0");
  userName.setColumns(10);
  userName.setBounds(156, 67, 232, 21);
  contentPane.add(userName);
  
  JLabel labelPW = new JLabel("\u5BC6\u7801\uFF1A");
  labelPW.setHorizontalAlignment(SwingConstants.CENTER);
  labelPW.setForeground(Color.BLACK);
  labelPW.setFont(new Font("����", Font.PLAIN, 14));
  labelPW.setBounds(5, 100, 141, 26);
  contentPane.add(labelPW);
  
  passwordField = new JTextField();
  passwordField.setToolTipText("\u60A8\u7684\u767B\u9646\u5BC6\u7801");
  passwordField.setColumns(10);
  passwordField.setBounds(156, 103, 232, 21);
  contentPane.add(passwordField);
  
  JLabel lblid = new JLabel("\u9879\u76EEID\uFF1A");
  lblid.setHorizontalAlignment(SwingConstants.CENTER);
  lblid.setForeground(Color.BLACK);
  lblid.setFont(new Font("����", Font.PLAIN, 14));
  lblid.setBounds(5, 136, 141, 26);
  contentPane.add(lblid);
  
  projectID = new JTextField();
  projectID.setToolTipText("\u6CE8\u610F\u9009\u62E9\u534E\u5357\u533A(cn-south-1)\u9879\u76EEID\u586B\u5165");
  projectID.setColumns(10);
  projectID.setBounds(156, 139, 232, 21);
  contentPane.add(projectID);
  
  JTextArea messageBoard = new JTextArea();
  messageBoard.setBackground(Color.WHITE);
  messageBoard.setEditable(false);
  messageBoard.setForeground(Color.BLACK);
  messageBoard.setLineWrap(true);
  messageBoard.setBounds(38, 382, 350, 92);
  contentPane.add(messageBoard);
  
  JLabel lblid_1 = new JLabel("\u5171\u4EAB\u955C\u50CFID\uFF1A");
  lblid_1.setHorizontalAlignment(SwingConstants.CENTER);
  lblid_1.setForeground(Color.BLACK);
  lblid_1.setFont(new Font("����", Font.PLAIN, 14));
  lblid_1.setBounds(5, 172, 141, 26);
  contentPane.add(lblid_1);
  
  imageID = new JTextField();
  imageID.setToolTipText("\u60A8\u6240\u9700\u8981\u590D\u5236\u7684\u955C\u50CF\u7684\u955C\u50CFID");
  imageID.setColumns(10);
  imageID.setBounds(156, 175, 232, 21);
  contentPane.add(imageID);
  
  JLabel label_1 = new JLabel("\u955C\u50CF\u540D\u79F0\uFF1A");
  label_1.setHorizontalAlignment(SwingConstants.CENTER);
  label_1.setForeground(Color.BLACK);
  label_1.setFont(new Font("����", Font.PLAIN, 14));
  label_1.setBounds(5, 208, 141, 26);
  contentPane.add(label_1);
  
  //CAD NAME
  imageName = new JTextField();
  imageName.setToolTipText("\u6B64\u955C\u50CF\u540D\u79F0\u662F\u4E3A\u60A8\u590D\u5236\u540E\u7684\u955C\u50CF\u53D6\u540D\uFF0C\u53EF\u4E0E\u539F\u955C\u50CF\u540D\u79F0\u4E0D\u540C\u3002\u6700\u7EC8\u521B\u5EFA\u684C\u9762\u7684\u65F6\u5019\u4F1A\u5728Console\u4E0A\u9009\u62E9\u8FD9\u4E2A\u540D\u5B57\uFF0C\u8BF7\u53D6\u59A5\u5584\u53D6\u540D\uFF0C\u5982\uFF1ACreo-GPU-80G");
  imageName.setColumns(10);
  imageName.setBounds(156, 211, 232, 21);
  contentPane.add(imageName);
  
  JButton IMGbutton = new JButton("\u590D\u5236\u955C\u50CF");
  IMGbutton.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
		//trim ending spaces
		imageIDContent = imageID.getText().trim();
		imageNameContent = imageName.getText().trim();
		accountNameContent = accountName.getText().trim();
		userNameContent = userName.getText().trim();
		passwordContent = passwordField.getText().trim();
		projectIDContent = projectID.getText().trim();
		//check empty input
		if(imageIDContent.isEmpty() || imageNameContent.isEmpty() || accountNameContent.isEmpty() || 
				userNameContent.isEmpty() || passwordContent.isEmpty() || projectIDContent.isEmpty()) {
			JOptionPane.showMessageDialog(null, "������Ϣ����Ϊ�գ�", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
  		int n = JOptionPane.showConfirmDialog(null, "ȷ�ϸ��ƾ���(�˲��������������ӣ������ĵȴ���","CONFIRMATION", JOptionPane.YES_NO_OPTION);
  		if(n==0) {
	  		try {
	  			Map<String, String> imageResponse = new HashMap<String, String>();
	  			Map<String, String> tokenResponse = new HashMap<String, String>();
	  			
	  			//��ȡToken
	  			tokenResponse = CallTokenAPI.getToken("https://iam.cn-south-1.myhuaweicloud.com/v3/auth/tokens", userNameContent, accountNameContent, projectIDContent, passwordContent);
	  			Integer tokenCode = Integer.parseInt(tokenResponse.get("code"));
	  			String tokenMessage = tokenResponse.get("message");
	  			if(tokenCode == 201) {
	  				tokenContent = tokenResponse.get("token");
	  			}else if(tokenCode == 401) {
	  				JOptionPane.showMessageDialog(null, "��֤ʧ�ܣ��˺Ż��������������", "401 Unauthorized", JOptionPane.ERROR_MESSAGE);
					messageBoard.setText(tokenMessage);
					return;
	  			}else if(tokenCode == 400) {
	  				JOptionPane.showMessageDialog(null, "���������ĿID�������", "400 Bad Request", JOptionPane.ERROR_MESSAGE);
					messageBoard.setText(tokenMessage);
					return;
	  			}else {
	  				JOptionPane.showMessageDialog(null, "��鿴��Ϣ�棬��Ҫ�����������ϵ����", tokenCode.toString()+" ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					messageBoard.setText(tokenMessage);
					return;
	  			}
	  			
	  			imageResponse = CallImageAPI.dupImage("https://ims.cn-south-1.myhuaweicloud.com/v1/cloudimages/imageID/copy", tokenContent, imageIDContent, imageNameContent);
	  			int imageCode = Integer.parseInt(imageResponse.get("code"));
	  			String imageMessage = imageResponse.get("message");
				if(imageCode==200) {
					JOptionPane.showMessageDialog(null, "���ƾ���ɹ������ڿ���̨�鿴���̣�ллʹ�ã�", "MISSION_SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "���ƾ���ʧ�ܣ�������б���������д", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					messageBoard.setText(imageMessage);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
  		}
  	}
  });
  IMGbutton.setAction(action_1);
  IMGbutton.setBounds(295, 272, 93, 23);
  contentPane.add(IMGbutton);
  
  JButton clearBtn = new JButton("New button");
  clearBtn.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent arg0) {
  		accountName.setText("");
  		userName.setText("");
  		projectID.setText("");
  		passwordField.setText("");
  		imageID.setText("");
  		imageName.setText("");
  	}
  });
  clearBtn.setAction(action_2);
  clearBtn.setBounds(181, 272, 93, 23);
  contentPane.add(clearBtn);
  
  JLabel lblNewLabel_1 = new JLabel("\u6CE81\uFF1A\u5C06\u9F20\u6807\u9759\u7F6E\u4E8E\u8F93\u5165\u6846\u4E2D\u53EF\u4EE5\u83B7\u5F97\u63D0\u793A");
  lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
  lblNewLabel_1.setForeground(Color.RED);
  lblNewLabel_1.setBounds(38, 244, 350, 26);
  contentPane.add(lblNewLabel_1);
  
  JLabel label = new JLabel("\u6D88\u606F\u677F");
  label.setFont(new Font("����", Font.BOLD, 14));
  label.setVerticalAlignment(SwingConstants.BOTTOM);
  label.setBounds(38, 346, 93, 26);
  contentPane.add(label);
  
  JLabel label_2 = new JLabel("\u7528\u6237\u540D\uFF1A");
  label_2.setHorizontalAlignment(SwingConstants.CENTER);
  label_2.setForeground(Color.BLACK);
  label_2.setFont(new Font("����", Font.PLAIN, 14));
  label_2.setBounds(5, 64, 141, 26);
  contentPane.add(label_2);
 }

	private class DuplicateImage extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2436754669822574896L;
		public DuplicateImage() {
			putValue(NAME, "���ƾ���");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class ClearAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8402288451277184938L;
		public ClearAction() {
			putValue(NAME, "���ñ���");
			putValue(SHORT_DESCRIPTION, "��ձ�������������");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}