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
	//��ѡ�Ի�����������
	String[] single_list={"��","Ů","Ů��ʿ","����Ա"};
	
	//��ѡ�Ի�����������
	String[] Multi_list={"����","����","����","Ů��"};
	
	//�б�Ի���ʹ������
	String[] item_list={"��Ŀ����","�߻�","����","����","����Ա"};	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initEvent();
	}

	/*
	 * ��ʼ������¼�
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
	 * ��ʾȷ�϶Ի���
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	public void showDialog1() {
		//Ҫ����һ��AlertDialog����Ҫ�õ�AlertDialog.Builder�е�create()����
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("ȷ�϶Ի���");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setMessage("ȷ�ϵĶԻ�����ʾ����");
		builder.setPositiveButton("ȷ��", new android.content.DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "�����ȷ����ť", Toast.LENGTH_SHORT).show();
			}
		});
	builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "�����ȡ����ť", Toast.LENGTH_SHORT).show();
		}
	});
	AlertDialog dialog=builder.create();
	dialog.show();//��ʾ�Ի���
	
	
	}
	
	public void showDialog2() {
		//Ҫ����һ��AlertDialog����Ҫ�õ�AlertDialog.Builder�е�create()����
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("ѡ���Ա�");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setSingleChoiceItems(single_list, 0, new DialogInterface.OnClickListener() {
			//��һ������Ϊ���飬0�����һ��ѡ�У���������Ϊ����¼�������
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//which�ǵ�ѡ��ťѡ�������һ��
				String str=single_list[which];
				Toast.makeText(MainActivity.this, "�������"+str+"!", Toast.LENGTH_SHORT).show();
			}
		});
	AlertDialog dialog=builder.create();
	dialog.show();//��ʾ�Ի���
	}
	
	public void showDialog3() {
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("����");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setMultiChoiceItems(Multi_list, null, new DialogInterface.OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					Toast.makeText(MainActivity.this, "��ϲ������"+Multi_list[which]+"!", Toast.LENGTH_SHORT).show();
				}else {
					Toast.makeText(MainActivity.this, "�Ҳ�ϲ��"+Multi_list[which]+"!", Toast.LENGTH_SHORT).show();
				}
			}
		});
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		AlertDialog dialog=builder.create();
		dialog.show();//��ʾ�Ի���
	}
	/*
	 * ��ʾ�б�Ի���
	 */
	public void showDialog4() {
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("�����б�");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setItems(item_list, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "�Ҷ���"+item_list[which]+"!", Toast.LENGTH_SHORT).show();
			}
		});
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();//�رնԻ���
			}
		});
		AlertDialog dialog=builder.create();//��ȡdialog
		dialog.show();//��ʾ�Ի���
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void showDialog5() {
		//LayoutInflater��������res/layout/�µ�xml�����ļ�������ʵ����
		LayoutInflater inflater=LayoutInflater.from(this);
		View view=inflater.inflate(R.layout.dialog_layout, null);
		
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("�Զ�����ʾ�Ի���");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setView(view);//�����Զ�����ʽ����
		AlertDialog dialog=builder.create();
		dialog.show();//��ʾ�Ի���
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
