package com.example.dialog;

import android.R.integer;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	//单选对话框所用数组
	String[] single_list={"男","女","女博士","程序员"};
	
	//多选对话框所用数组
	String[] Multi_list={"篮球","足球","男生","女生"};
	
	//列表对话框使用数组
	String[] item_list={"项目经理","策划","测试","美工","程序员"};	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initEvent();
	}

	/*
	 * 初始化点击事件
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	public void initEvent(){
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog1();		
			}
		});
		findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
			
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			showDialog2();		
			}	
		});
		findViewById(R.id.button3).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog3();		
			}	
	 });
		findViewById(R.id.button4).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog4();		
			}			
		 });
		findViewById(R.id.button5).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog5();		
			}	
	 });
	}
	/*
	 * 显示确认对话框
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	public void showDialog1() {
		//要创建一个AlertDialog，就要用到AlertDialog.Builder中的create()方法
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("确认对话框");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setMessage("确认的对话框提示内容");
		builder.setPositiveButton("确认", new android.content.DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_SHORT).show();
			}
		});
	builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
		}
	});
	AlertDialog dialog=builder.create();
	dialog.show();//显示对话框
	
	
	}
	
	public void showDialog2() {
		//要创建一个AlertDialog，就要用到AlertDialog.Builder中的create()方法
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("选择性别");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setSingleChoiceItems(single_list, 0, new DialogInterface.OnClickListener() {
			//第一个参数为数组，0代表第一个选中，第三参数为点击事件监听器
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//which是单选按钮选择的是哪一个
				String str=single_list[which];
				Toast.makeText(MainActivity.this, "这个人是"+str+"!", Toast.LENGTH_SHORT).show();
			}
		});
	AlertDialog dialog=builder.create();
	dialog.show();//显示对话框
	}
	
	public void showDialog3() {
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("爱好");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setMultiChoiceItems(Multi_list, null, new DialogInterface.OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					Toast.makeText(MainActivity.this, "我喜欢上了"+Multi_list[which]+"!", Toast.LENGTH_SHORT).show();
				}else {
					Toast.makeText(MainActivity.this, "我不喜欢"+Multi_list[which]+"!", Toast.LENGTH_SHORT).show();
				}
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		AlertDialog dialog=builder.create();
		dialog.show();//显示对话框
	}
	/*
	 * 显示列表对话框
	 */
	public void showDialog4() {
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("部门列表");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setItems(item_list, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "我动了"+item_list[which]+"!", Toast.LENGTH_SHORT).show();
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();//关闭对话框
			}
		});
		AlertDialog dialog=builder.create();//获取dialog
		dialog.show();//显示对话框
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void showDialog5() {
		//LayoutInflater是用来找res/layout/下的xml布局文件，并且实例化
		LayoutInflater inflater=LayoutInflater.from(this);
		View view=inflater.inflate(R.layout.dialog_layout, null);
		
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("自定义显示对话框");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setView(view);//设置自定义样式布局
		AlertDialog dialog=builder.create();
		dialog.show();//显示对话框
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
