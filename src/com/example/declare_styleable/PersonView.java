package com.example.declare_styleable;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
/**
 * �������Զ���һ��View���̳���TextView�������Զ�������ȥ�жϲ���������Ϣ
 * @author RA
 * @blog http://blog.csdn.net/vipzjyno1
 */
public class PersonView extends TextView {
	public PersonView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public PersonView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public PersonView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		TypedArray tArray = context.obtainStyledAttributes(attrs,
				R.styleable.PersonAttr);
		String name = tArray.getString(R.styleable.PersonAttr_name);
		int age = tArray.getInt(R.styleable.PersonAttr_age, 15);
		Boolean adult = tArray.getBoolean(R.styleable.PersonAttr_adult, false);
		String str_adult = getAdultStatus(adult);
		int weight = tArray.getInt(R.styleable.PersonAttr_weight, 1);// Ĭ�����е���ģ�����Ϊ:1
		String str_weight = getWeightStatus(weight);
		float textSize = tArray.getDimension(R.styleable.PersonAttr_textSize,R.dimen.default_text_size);// ���������ΪDP�ȵ�λ����������ת��
		tArray.recycle();
//		setTextSize(textSize);
		setText("������" + name + "\n" + "���䣺" + age + "\n" + "�Ƿ���꣺" + str_adult
				+ "\n" + "���Σ�" + str_weight);
	}
	
	/** ���ݴ����ֵ�ж��Ƿ���� */
	public String getAdultStatus(Boolean adult ){
		String str_adult = "δ����";
		if (adult) {
			str_adult = "����";
		}
		return str_adult;
	}
	
	/** ���ݴ����ֵ�жϷ���״̬ */
	public String getWeightStatus(int weight){
		String str_weight = "�е�";
		switch (weight) {
		case 0:
			str_weight = "��";
			break;
		case 1:
			str_weight = "�е�";
			break;
		case 2:
			str_weight = "����";
			break;
		default:
			break;
		}
		return str_weight;
	}
}
