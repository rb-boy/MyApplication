package com.example.a23201.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.math.BigDecimal;
import java.util.*;
import android.widget.*;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_0 ;
    Button btn_1;
    Button btn_2;
    Button btn_3 ;
    Button btn_4 ;
    Button btn_5 ;
    Button btn_6 ;  //数字按钮
    Button btn_7 ;
    Button btn_8 ;
    Button btn_9 ;
    Button btn_dian;
    Button btn_deng;
    Button btn_der;
    Button btn_jia;
    Button btn_jian;
    Button btn_cheng;
    Button btn_chu;
    Button btn_C;
    TextView ttvjieguo;
    TextView ttvxian;
    boolean clear_flag ;
    boolean clear_dian=true;
    boolean clear_fuhao=true;
    boolean del=true;
    List<String> list = new ArrayList<>();
    private StringBuffer sbuf =new StringBuffer();
    private StringBuffer sl =new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.btn_0) ;
        btn_1 = (Button) findViewById(R.id.btn_1) ;
        btn_2 = (Button) findViewById(R.id.btn_2) ;
        btn_3 = (Button) findViewById(R.id.btn_3) ;
        btn_4 = (Button) findViewById(R.id.btn_4) ;
        btn_5 = (Button) findViewById(R.id.btn_5) ;
        btn_6 = (Button) findViewById(R.id.btn_6) ;
        btn_7 = (Button) findViewById(R.id.btn_7) ;
        btn_8 = (Button) findViewById(R.id.btn_8) ;
        btn_9 = (Button) findViewById(R.id.btn_9) ;
        btn_C=(Button) findViewById(R.id.btn_C);
        btn_dian=(Button) findViewById(R.id.btn_dian);
        btn_deng=(Button) findViewById(R.id.btn_deng);
        btn_der=(Button) findViewById(R.id.btn_der);
        btn_jia=(Button) findViewById(R.id.btn_jia);
        btn_jian=(Button) findViewById(R.id.btn_jian);
        btn_cheng=(Button) findViewById(R.id.btn_cheng);
        btn_chu=(Button) findViewById(R.id.btn_chu);
        ttvjieguo=(TextView) findViewById(R.id.ttvjieguo);
        ttvxian=(TextView) findViewById(R.id.ttvxian);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_C.setOnClickListener(this);
        btn_dian.setOnClickListener(this);
        btn_deng.setOnClickListener(this);
        btn_der.setOnClickListener(this);
        btn_jia.setOnClickListener(this);
        btn_jian.setOnClickListener(this);
        btn_cheng.setOnClickListener(this);
        btn_chu.setOnClickListener(this);
    }
    public void onClick(View v) {
        String str = ttvxian.getText().toString();
        String str1 =ttvjieguo.getText().toString();
        switch (v.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
                if (clear_flag) {
                    clear_flag =false ;
                    str ="" ;
                    ttvxian.setText("");
                }
                clear_fuhao=true;
                sbuf.append(((Button)v).getText());

                ttvxian.setText(prin()+sbuf);
                break ;
            case R.id.btn_dian:
                if(list.size()==0)
                    clear_dian=true;
                if(clear_dian) {
                    if (clear_flag) {
                        clear_flag =false ;
                        str ="" ;
                        ttvxian.setText("");
                    }
                    sbuf.append(((Button)v).getText());
                    ttvxian.setText(prin()+sbuf);
                    clear_dian=false;
                }
                break;
            case R.id.btn_jia:
            case R.id.btn_jian:
            case R.id.btn_chu:
            case R.id.btn_cheng:

                if(clear_fuhao) {
                    if (clear_flag) {
                        clear_flag =false ;
                        list.add(ttvjieguo.getText().toString());
                        ttvxian.setText("");
                    }
                clear_fuhao=false;
                    list.add(sbuf.toString());
                    list.add(((Button)v).getText().toString());
                    ttvxian.setText(prin());
                    clear_dian=true;
                    sbuf.setLength(0);
                    del=true;
                }
                break;
            case R.id.btn_der:
                if(ttvxian.getText()==null){
                    return;
                }
                if (sbuf.length()==0) {
                    if(list.size()>0) {
                        list.remove(list.size() - 1);
                        sbuf.append(list.get(list.size() - 1));
                        ttvxian.setText(prin());
                    }
                }else if(list.size()==0||del){
                    sbuf.deleteCharAt(sbuf.length() - 1);
                    list.add(sbuf.toString());
                    ttvxian.setText(prin());
                    del=false;
                }else {
                    sbuf.deleteCharAt(sbuf.length() - 1);
                    list.set(list.size()-1,sbuf.toString());
                    ttvxian.setText(prin());
                }
                break;
            case R.id.btn_C:
                ttvxian.setText("");
                list.clear();
                sbuf.setLength(0);
                ttvxian.setText(null);
                break;
            case R.id.btn_deng:
                list.add(sbuf.toString());
                getResult3();
                sl=null;
                break ;

        }
     }

    private String prin() {

        StringBuffer st=new StringBuffer();
        if(list.size()!=0) {
            for (int i = 0; i < list.size(); i++) {
                st.append(list.get(i).toString());
            }
        }
        return  st.toString();
    }
    private void getResult3(){


        if (list.size()==0){
            return;
        }
        if (clear_flag){
            clear_flag = false ;
            return;
        }
        clear_flag = true ;
        try {
            Double temp;
            for(int i=0;i<list.size();i++) {
                if (list.get(i) == null) {
                    continue;
                }
                if (list.get(i).equals("*")) {
                    BigDecimal b1 = new BigDecimal(list.get(i - 1).toString());
                    BigDecimal b2 = new BigDecimal(list.get(i + 1).toString());
                    temp = b1.multiply(b2).doubleValue();
                    list.remove(i - 1);
                    list.remove(i - 1);
                    list.remove(i - 1);
                    list.add(i - 1, String.valueOf(temp));
                } else if (list.get(i).equals("/")) {
                    BigDecimal b1 = new BigDecimal(list.get(i - 1).toString());
                    BigDecimal b2 = new BigDecimal(list.get(i + 1).toString());
                    temp = b1.divide(b2).doubleValue();
                    list.remove(i - 1);
                    list.remove(i - 1);
                    list.remove(i - 1);
                    list.add(i - 1, String.valueOf(temp));
                }
            }
            double ss=Double.parseDouble(list.get(0).toString());
            for (int h = 0; h < list.size(); h++){
                if (list.get(h).equals("+")) {
                     if (h+1<list.size()) {
                        double d2 = Double.parseDouble(list.get(h+1).toString());
                         ss = ss + d2;
                     }
                } else if (list.get(h).equals("-")) {
                    if (h + 1 < list.size()) {
                        double d2 = Double.parseDouble(list.get(h+1).toString());
                        ss = ss - d2;
                    }
                }
            }
            list.clear();
            ttvjieguo.setText(ss+"");

        }catch (Exception e){}

    }

    private void getResult(){
        /*String exp = ttvxian.getText().toString();
        if (exp==null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")) {
            return;
        }
        if (clear_flag){
            clear_flag = false ;
            return;

        }
        clear_flag = true ;
        double result = 0 ;
        String s1 = exp.substring(0,exp.indexOf(" "));
        String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2) ;
        String s2 = exp.substring(exp.indexOf(" ")+3) ;
        if (!s1.equals("")&&!s2.equals("")){
            double d1 = Double.parseDouble(s1) ;
            double d2 = Double.parseDouble(s2) ;
            if (op.equals("+")){
                result = d1 + d2 ;

            }else  if (op.equals("-")){
                result = d1 - d2 ;

            }else  if (op.equals("*")){
                result = d1 * d2 ;

            }else  if (op.equals("/")){
                if(d2 == 0){
                    result = 0 ;
                }else {
                    result = d1/d2 ;
                }
            }
            if (s1.contains(".")&&s2.contains(".")) {
                int r = (int) result;
                ttvjieguo.setText(r+"");
            }else {
                ttvjieguo.setText(result+"");

            }
        }else if (!s1.equals("")&&s2.equals("")){
            ttvjieguo.setText(exp);
        }else if (s1.equals("")&&!s2.equals("")){
            double d2 = Double.parseDouble(s2) ;
            if (op.equals("+")){
                result = 0 + d2 ;

            }else  if (op.equals("-")){
                result = 0 - d2 ;

            }else  if (op.equals("*")){
                result = 0 ;

            }else  if (op.equals("/")){
                result = 0 ;
            }
            if (s2.contains(".")) {
                int r = (int) result;
                ttvjieguo.setText(r+"");
            }else {
                ttvjieguo.setText(result+"");
            }
        }else {
            ttvjieguo.setText("");

        }*/
    }
}
