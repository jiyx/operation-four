package jiedui;
  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.*;
import java.lang.*;
   class Num{                              //定义数字类
     private int a;
         public Num()
     {
         this.a = (int)(Math.random()*10000);
     }
     
     public Num(int i)
     {
         this.a = (int)(Math.random()*4)+1;
    }
     
     public int get_num()
     {
         return this.a;
     }
     
     public int num_sum(Num B)
     {
         return this.a + B.a;
     }
     
     public int num_dec(Num B)
     {
         return this.a - B.a;
     }
     
    public int num_c(Num B)
     { 
    	return this.a * B.a;
    }
    
     public int num_chu(Num B)
     {
         return this.a / B.a;
     }
     
    public void flash()
     {
         this.a = (int)(Math.random()*100);
		}
     
     public void flash_t()
    {
         this.a = (int)(Math.random()*4)+1;
     }
     
     public boolean pd(int i)
     {
         if(this.a == i)
             return true;
         else
             return false;
     }
}
   public class jiedui {
	    private static Num a = new Num();  //a,b
	    private static Num b = new Num();
	    private static Num c = new Num(1);
	    private static int q = 0;
	    private static String p;
	    private static JFrame frame = new JFrame("简单四则运算");
	    private static JLabel label1 = new JLabel("A");
	    private static JLabel label2 = new JLabel("*");
	    private static JLabel label3 = new JLabel("B");
	    private static JLabel label4 = new JLabel(" "+"="+" ");
	    private static JLabel label5 = new JLabel("结果");
	    private static JButton button = new JButton("查看");
	    private static JButton bt1 = new JButton("下一题");
	    private static JButton bt2 = new JButton("退出");
	    private static JTextField text = new JTextField(5);
	    private static JPanel pane = new JPanel();  //容器
	    
	    public static void main(String[] args) {
	        pane.setBorder(BorderFactory.createEmptyBorder(20,60,20,60));
	        pane.setLayout(new GridLayout(0,5));  //设置布局
	        pane.add(label1);
	        pane.add(label2);
	        pane.add(label3);
	        pane.add(label4);
	        pane.add(text);
	        pane.add(label5);
	        pane.add(button);
	        pane.add(bt1);
	        pane.add(bt2);

	        if(c.pd(1)) 
	        {
	            p = "+";
	            q = a.num_sum(b);
	        }
	        if(c.pd(2))
	        {
	            p = "-";
	            q = a.num_dec(b);
	        }
	        if(c.pd(3))
	        {
	            p = "*";
	            q = a.num_c(b);
	        }
	        if(c.pd(4))
	        {
	            p = "/";
	            q = a.num_chu(b);
	        }
	         
	        frame.getContentPane().add(pane,BorderLayout.CENTER);
	        button.setMnemonic(KeyEvent.VK_I);
	         
	        button.addActionListener(new ActionListener(){  //鼠标单击事件
	            public void actionPerformed(ActionEvent e){
	                if(q == Integer.parseInt(text.getText().trim()))
	                    label5.setText("正确！");
	                else
	                    label5.setText("错误！");
	                
	            }
	        });
	        
	        bt1.setMnemonic(KeyEvent.VK_H);
	        bt1.addActionListener(new ActionListener(){  //鼠标单击事件
	            public void actionPerformed(ActionEvent e){
	                a.flash();
	                b.flash();
	                c.flash_t();
	                if(c.pd(1)) 
	                {
	                    p = "+";
	                    q = a.num_sum(b);
	                }
	                if(c.pd(2))
	                {
	                    p = "-";
	                    q = a.num_dec(b);
	                }
	                if(c.pd(3))
	                {
	                    p = "*";
	                    q = a.num_c(b);
	                }
	                if(c.pd(4))
	                {
	                    p = "/";
	                    q = a.num_chu(b);
	                }
	                label1.setText(" "+a.get_num()+" ");
	                label2.setText(p);
	                label3.setText(" "+b.get_num()+" ");
	                text.setText(" ");
	                label5.setText("结果");
	            }
	        });
	        
	        bt2.setMnemonic(KeyEvent.VK_T);
	        bt2.addActionListener(new ActionListener(){  //鼠标单击事件
	            public void actionPerformed(ActionEvent e){
	                System.exit(0);
	                
	            }
	        });
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.pack();
	        label1.setText(" "+a.get_num()+" ");
	        label2.setText(p);
	        label3.setText(" "+b.get_num()+" ");
	        
	        frame.setVisible(true);
	    }
	}