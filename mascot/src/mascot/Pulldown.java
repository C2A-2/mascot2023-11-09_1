package mascot;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Pulldown extends JFrame implements ActionListener , MouseListener ,WindowListener{
	// フィールド宣言
	JComboBox<String> comboBox = new JComboBox<String>();
	// GUI画面の設定
	JFrame frame = new JFrame("メニュー");
	
	boolean ON2;
	
	//サーチメニューチェック
	static boolean searchWindowCheck=false;
	
	//int j=0;
	
	//メイン処理 
	
//	public static void main(String[] args) {
//		// プルダウン作成クラスのインスタンス
//		new Pulldown();
//	}
	
	// コンストラクタ
	public Pulldown(boolean menuWindowCheck){
		
		ON2=menuWindowCheck;
		
		//frame.setLayout(new FlowLsayout());
		//getContentPane().setLayout(new FlowLayout());
		
		//レイアウト無効
		frame.setLayout(null);
		//setTitle("メニュー");
		
		
		// ボタンの生成
		JButton btn = new JButton("決定");
		
		
		
		// ボタン押下時の処理を設定
		btn.addActionListener(this);
		
		// プルダウンの追加
		comboBox.addItem("沼情");
		comboBox.addItem("検索");
		comboBox.addItem("電卓");
		comboBox.addItem("メモ帳");
		
		//comboBox.setBounds(100,100,100,100);
		
		// プルダウンを画面に追加
		//getContentPane().add(comboBox);
		frame.add(comboBox);
		comboBox.setBounds(50,20,100,30);
		
		// ボタンを画面に追加
		//getContentPane().add(btn);
		
		frame.add(btn);
		btn.setBounds(170,20,70,30);
		
		
		// GUIを閉じた時、プログラムも終了
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//終了設定
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
		//ラベル設定
		//getContentPane().add(frame);
		
		
		// サイズを設定
		//setSize(300, 100);
		frame.setSize(300, 100);
		
		//ウィンドウ位置座標
		//getContentPane().setBounds(100,100,500,300);
		//frame.setBounds(800,200,300,150);
		frame.setLocation(980,410);
		
		// GUI画面の可視化
		//getContentPane().setVisible(true);
		frame.setVisible(true);
		
		frame.addMouseListener(this);
		frame.addWindowListener(this);
		
		// 枠を外す。
		//setUndecorated(true);
		//frame.setUndecorated(true);
        // 背景色を透明にする。
        //setBackground(new Color(0, 0, 0, 0));
        // タスクバーのアイコンを非表示
        //setType(Type.UTILITY) ;
		//frame.setType(Type.UTILITY) ;
	}
	
	
	
	// ボタンクリック時の処理
	public void actionPerformed(ActionEvent ae) {
		
//		// 選択したプルダウンに応じてメッセージを出力
//		JOptionPane.showMessageDialog(null,
//			"選択項目：" + comboBox.getSelectedItem(),
//			"プルダウン選択内容",
//			JOptionPane.INFORMATION_MESSAGE);
		
		if(comboBox.getSelectedItem()=="沼情") {
			
			Desktop desktop = Desktop.getDesktop();
			try {
				Main.checkreturn(ON2);
				desktop.browse(new URI("https://www.numasen.ac.jp/department/computer/"));
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
		}else if(comboBox.getSelectedItem()=="検索"){
			Main.checkreturn(ON2);
			if(searchWindowCheck==false) {
				searchWindowCheck=true;
				new Search(searchWindowCheck);//.setVisible(true);
			}
			
			frame.dispose();
			
		}else if(comboBox.getSelectedItem()=="電卓") {
			try {
			      Runtime rt = Runtime.getRuntime();
			      rt.exec("calc.exe");
			    } catch (IOException ex) {
			      ex.printStackTrace();
			    }
		}else if(comboBox.getSelectedItem()=="メモ帳") {
			 try {
			      Runtime rt = Runtime.getRuntime();
			      rt.exec("notepad.exe");
			    } catch (IOException ex) {
			      ex.printStackTrace();
			    }
			  
		}
	}
	
	public static void checkreturn(boolean ON2) {
		searchWindowCheck=ON2;
		searchWindowCheck=false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
		
		System.out.println("離れた");
	}



	@Override
	public void windowOpened(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		Main.checkreturn(ON2);
		frame.dispose();
		System.out.println("メニューウィンドウ閉じる");
	}



	@Override
	public void windowClosed(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowIconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowActivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	
	
	
	
	
	
		
		
}
	
	

	