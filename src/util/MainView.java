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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainView extends JFrame {
	//util functions
	private static boolean checkRegEx(String regEx, String toCheck) {
		boolean check = false;
		//case insensitive
		Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(toCheck);
		check = matcher.matches();
		return check;
	}
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
 private JPasswordField passwordField; 
 
 private String accountNameContent;
 private String userNameContent;
 private String projectIDContent;
 private String passwordContent;
 private String imageIDContent;
 private String imageNameContent;
 private String tokenContent;
 private String endpointContent = "";
 
 boolean nameCheck;
 boolean IDCheck;
 
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
 @SuppressWarnings({ "rawtypes", "unchecked" })
public MainView() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 437, 566);
  setTitle("Huawei Cloud IMG Duplicating Kit v3.0");
//  setSize(510, 520);
  contentPane = new JPanel();
  contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(255, 0, 0)), "\u534E\u4E3A\u4E91\u955C\u50CF\u590D\u5236\u5C0F\u5DE5\u5177", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  JLabel lblregion = new JLabel("\u5730\u533ARegion\uFF1A");
  lblregion.setHorizontalAlignment(SwingConstants.CENTER);
  lblregion.setForeground(Color.BLACK);
  lblregion.setFont(new Font("宋体", Font.PLAIN, 14));
  lblregion.setBounds(10, 26, 141, 26);
  contentPane.add(lblregion);
  
  JComboBox<String> regionEndpnt = new JComboBox<String>();
  regionEndpnt.setModel(new DefaultComboBoxModel(Region.values()));
  regionEndpnt.setBounds(161, 27, 232, 21);
  contentPane.add(regionEndpnt);
  regionEndpnt.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		  if(e.getSource() instanceof JComboBox) {
			  JComboBox<String> comboBox = (JComboBox)e.getSource();
			  Region selected = (Region)comboBox.getSelectedItem();
			  endpointContent = selected.getEndpoint();
		  }
	  }
  });
  
  JLabel lblNewLabel = new JLabel("\u534E\u4E3A\u4E91\u8D26\u53F7\u540D\uFF1A");
  lblNewLabel.setForeground(new Color(0, 0, 0));
  lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
  lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
  lblNewLabel.setBounds(10, 62, 141, 26);
  contentPane.add(lblNewLabel);
  
  accountName = new JTextField();
  accountName.setToolTipText("\u5B50\u7528\u6237\u6240\u5C5E\u4F01\u4E1A\u8D26\u6237\u540D\u79F0");
  accountName.setBounds(161, 65, 232, 21);
  contentPane.add(accountName);
  accountName.setColumns(10);
  
  userName = new JTextField();
  userName.setToolTipText("\u4F01\u4E1A\u5BA2\u6237\u4E3A\u5408\u4F5C\u65B9\u521B\u5EFA\u7684\u5B50\u7528\u6237\u7684\u540D\u79F0");
  userName.setColumns(10);
  userName.setBounds(161, 101, 232, 21);
  contentPane.add(userName);
  
  JLabel labelPW = new JLabel("\u5BC6\u7801\uFF1A");
  labelPW.setHorizontalAlignment(SwingConstants.CENTER);
  labelPW.setForeground(Color.BLACK);
  labelPW.setFont(new Font("宋体", Font.PLAIN, 14));
  labelPW.setBounds(10, 134, 141, 26);
  contentPane.add(labelPW);
  
  passwordField = new JPasswordField();
  passwordField.setToolTipText("\u60A8\u7684\u767B\u9646\u5BC6\u7801");
  passwordField.setColumns(10);
  passwordField.setBounds(161, 137, 232, 21);
  contentPane.add(passwordField);
  
  JLabel lblid = new JLabel("\u9879\u76EEID\uFF1A");
  lblid.setHorizontalAlignment(SwingConstants.CENTER);
  lblid.setForeground(Color.BLACK);
  lblid.setFont(new Font("宋体", Font.PLAIN, 14));
  lblid.setBounds(10, 170, 141, 26);
  contentPane.add(lblid);
  
  projectID = new JTextField();
  projectID.setToolTipText("\u8BF7\u9009\u62E9\u534E\u5357\u533A(cn-south-1)\u9879\u76EEID\u586B\u5165\uFF0C\u6CE8\u610F\u4E0D\u662F\u955C\u50CF\u7684\u9879\u76EEID");
  projectID.setColumns(10);
  projectID.setBounds(161, 173, 232, 21);
  contentPane.add(projectID);
  
  JTextArea imageNameErrMsg = new JTextArea("");
  imageNameErrMsg.setEditable(false);
  imageNameErrMsg.setBackground(UIManager.getColor("Button.background"));
  imageNameErrMsg.setForeground(Color.RED);
  imageNameErrMsg.setBounds(43, 299, 350, 47);
  contentPane.add(imageNameErrMsg);
  
  JLabel label = new JLabel("\u6D88\u606F\u677F");
  label.setFont(new Font("宋体", Font.BOLD, 14));
  label.setVerticalAlignment(SwingConstants.BOTTOM);
  label.setBounds(43, 349, 93, 26);
  contentPane.add(label);
  
  JLabel label_2 = new JLabel("\u5B50\u7528\u6237\u540D\uFF1A");
  label_2.setHorizontalAlignment(SwingConstants.CENTER);
  label_2.setForeground(Color.BLACK);
  label_2.setFont(new Font("宋体", Font.PLAIN, 14));
  label_2.setBounds(10, 98, 141, 26);
  contentPane.add(label_2);
  
  JTextArea imageIDErrMsg = new JTextArea("");
  imageIDErrMsg.setEditable(false);
  imageIDErrMsg.setForeground(Color.RED);
  imageIDErrMsg.setBackground(UIManager.getColor("Button.background"));
  imageIDErrMsg.setBounds(43, 232, 350, 26);
  contentPane.add(imageIDErrMsg);
  
  JTextArea messageBoard = new JTextArea();
  messageBoard.setFont(new Font("宋体", Font.PLAIN, 14));
  messageBoard.setBackground(Color.WHITE);
  messageBoard.setEditable(false);
  messageBoard.setForeground(Color.BLACK);
  messageBoard.setLineWrap(true);
  messageBoard.setBounds(38, 385, 350, 133);
  contentPane.add(messageBoard);
  
  JLabel lblid_1 = new JLabel("\u5171\u4EAB\u955C\u50CFID\uFF1A");
  lblid_1.setHorizontalAlignment(SwingConstants.CENTER);
  lblid_1.setForeground(Color.BLACK);
  lblid_1.setFont(new Font("宋体", Font.PLAIN, 14));
  lblid_1.setBounds(10, 206, 141, 26);
  contentPane.add(lblid_1);
  
  imageID = new JTextField();
  imageID.addFocusListener(new FocusAdapter() {
  	@Override
  	public void focusLost(FocusEvent arg0) {
  		imageIDContent = imageID.getText().trim();
  		String regEx = "^([0-9a-fA-F]){8}-([0-9a-fA-F]){4}-([0-9a-fA-F]){4}-([0-9a-fAF]){4}-([0-9a-fA-F]){12}$";
  		IDCheck = checkRegEx(regEx, imageIDContent);
  		if(!IDCheck) {
  			imageIDErrMsg.setText("注意！镜像ID格式错误！请重新填写。");
  		}
  		else {
  			imageIDErrMsg.setText("格式正确^_^");
  		}
  	}
  });
  imageID.setToolTipText("\u60A8\u6240\u9700\u8981\u590D\u5236\u7684\u955C\u50CF\u7684\u955C\u50CFID");
  imageID.setColumns(10);
  imageID.setBounds(161, 209, 232, 21);
  contentPane.add(imageID);
  
  JLabel label_1 = new JLabel("\u955C\u50CF\u540D\u79F0\uFF1A");
  label_1.setHorizontalAlignment(SwingConstants.CENTER);
  label_1.setForeground(Color.BLACK);
  label_1.setFont(new Font("宋体", Font.PLAIN, 14));
  label_1.setBounds(10, 268, 141, 26);
  contentPane.add(label_1);
  
  //CAD NAME
  imageName = new JTextField();
  imageName.addFocusListener(new FocusAdapter() {
  	@Override
  	public void focusLost(FocusEvent e) {
  		imageNameContent = imageName.getText().trim();
  		String regEx = "^[a-zA-Z0-9_.-]$|^[a-zA-Z0-9_.-][a-zA-Z0-9_. -]*[a-zA-Z0-9_.-]$";
  		nameCheck = checkRegEx(regEx, imageNameContent);
  		if(!nameCheck) {
  			imageNameErrMsg.setText("注：镜像名称只能由字母数字空格和特殊字符-_.组成,\r\n" + 
  					"且首尾字符都不能为空格");
  		}else {
  			imageNameErrMsg.setText("格式正确^_^");
  		}
  	}
  });
  imageName.setToolTipText("\u4E3A\u590D\u5236\u540E\u7684\u955C\u50CF\u53D6\u540D\uFF0C\u53EF\u4E0E\u539F\u540D\u4E0D\u540C\u3002");
  imageName.setColumns(10);
  imageName.setBounds(161, 268, 232, 21);
  contentPane.add(imageName);
  
  JButton IMGbutton = new JButton("\u590D\u5236\u955C\u50CF");
  IMGbutton.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
		//trim ending spaces
		imageIDContent = imageID.getText().trim();
		imageNameContent = imageName.getText().trim();
		accountNameContent = accountName.getText().trim();
		userNameContent = userName.getText().trim();
		passwordContent = String.valueOf(passwordField.getPassword()).trim();
		projectIDContent = projectID.getText().trim();
		//check empty input
		if(imageIDContent.isEmpty() || imageNameContent.isEmpty() || accountNameContent.isEmpty() || 
				userNameContent.isEmpty() || passwordContent.isEmpty() || projectIDContent.isEmpty()||endpointContent.isEmpty()) {
			JOptionPane.showMessageDialog(null, "输入信息不能为空！", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
  		int n = JOptionPane.showConfirmDialog(null, "确认复制镜像？(此操作将持续几秒钟，请耐心等待）","CONFIRMATION", JOptionPane.YES_NO_OPTION);
  		if(n==0) {
  	  		if(!nameCheck || !IDCheck) {
  	  			JOptionPane.showMessageDialog(null, "您输入的镜像名称或者镜像ID不符合格式！", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
  	  			return;
  	  		}
	  		try {
	  			Map<String, String> imageResponse = new HashMap<String, String>();
	  			Map<String, String> tokenResponse = new HashMap<String, String>();
	  			
	  			//获取Token
	  			String tokenAPI = "https://iam." + endpointContent + ".myhuaweicloud.com/v3/auth/tokens";
	  			tokenResponse = CallTokenAPI.getToken(tokenAPI, userNameContent, accountNameContent, projectIDContent, passwordContent);
	  			messageBoard.setText(tokenAPI);
	  			Integer tokenCode = Integer.parseInt(tokenResponse.get("code"));
	  			String tokenMessage = tokenResponse.get("message");
	  			if(tokenCode == 201) {
	  				tokenContent = tokenResponse.get("token");
	  			}else if(tokenCode == 401) {
	  				JOptionPane.showMessageDialog(null, "认证失败：账号或者密码输入错误.", "401 Unauthorized", JOptionPane.ERROR_MESSAGE);
					messageBoard.setText(tokenMessage);
					return;
	  			}else if(tokenCode == 400) {
	  				JOptionPane.showMessageDialog(null, "请求错误：项目ID输入错误.", "400 Bad Request", JOptionPane.ERROR_MESSAGE);
					messageBoard.setText(tokenMessage);
					return;
	  			}else {
	  				JOptionPane.showMessageDialog(null, "请查看消息版，需要更多帮助请联系我们.", tokenCode.toString()+" ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					messageBoard.setText(tokenMessage);
					return;
	  			}
	  			
	  			String imsAPI = "https://ims." + endpointContent + ".myhuaweicloud.com/v1/cloudimages/imageID/copy";
	  			imageResponse = CallImageAPI.dupImage(imsAPI, tokenContent, imageIDContent, imageNameContent);
	  			messageBoard.setText(imsAPI);
	  			int imageCode = Integer.parseInt(imageResponse.get("code"));
	  			String imageMessage = imageResponse.get("message");
				if(imageCode==200) {
					JOptionPane.showMessageDialog(null, "复制镜像成功！请在控制台查看进程，谢谢使用！", "MISSION_SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					messageBoard.setText("感谢您的支持！");
				}else if(imageCode == 400) {
					JOptionPane.showMessageDialog(null, "复制镜像失败，请查看消息版，需要更多帮助请联系我们.", "400 Bad Request", JOptionPane.ERROR_MESSAGE);
					messageBoard.setText(imageMessage + "\n找到“code”所对应的值，并在下面链接中匹配错误原因，谢谢。\nhttps://support.huaweicloud.com/api-ims/zh-cn_topic_0022473689.html");
				}else {
					JOptionPane.showMessageDialog(null, "复制镜像失败，请清空列表后重新填写,需要更多帮助请联系我们.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
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
  IMGbutton.setBounds(300, 352, 93, 23);
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
  clearBtn.setBounds(186, 352, 93, 23);
  contentPane.add(clearBtn);
 }

	private class DuplicateImage extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2436754669822574896L;
		public DuplicateImage() {
			putValue(NAME, "复制镜像");
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
			putValue(NAME, "重置表单");
			putValue(SHORT_DESCRIPTION, "清空表单以重新输入");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}