package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Salim Khan","Hospital Address : Etawah","Exp: 25yrs","Mobile No:9898989898","1600"},
                    {"Doctor Name : Sanju Patil","Hospital Address : Auraiya","Exp: 20yrs","Mobile No:9797979797","1000"},
                    {"Doctor Name : Anjana Kaushisk","Hospital Address : Auraiya","Exp: 15yrs","Mobile No:9696969696","900"},
                    {"Doctor Name : Anshu Patil","Hospital Address : Ajitmal","Exp: 10yrs","Mobile No:9595959595","800"},
                    {"Doctor Name : Himanshu Porwal","Hospital Address : Delhi","Exp: 5yrs","Mobile No:9494949494","600"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Neelam Patil","Hospital Address : Mumbai","Exp: 25yrs","Mobile No:9393939393","1800"},
                    {"Doctor Name : Suresh Chaudary","Hospital Address : Indore","Exp: 20yrs","Mobile No:9292929292","1400"},
                    {"Doctor Name : Mukesh Mewada","Hospital Address : Indore","Exp: 15yrs","Mobile No:9191919191","1200"},
                    {"Doctor Name : Gaurav Prakash","Hospital Address : Bihar","Exp: 10yrs","Mobile No:9090909090","1000"},
                    {"Doctor Name : Rahul Kumawat","Hospital Address : Jaipur","Exp: 5yrs","Mobile No:8989898989","800"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Himanshu Mishra","Hospital Address : Menpuri","Exp: 25yrs","Mobile No:8888888888","2600"},
                    {"Doctor Name : Anjana Porwal","Hospital Address : Babarpur","Exp: 20yrs","Mobile No:8787878787","2500"},
                    {"Doctor Name : Sanjeev Porwal","Hospital Address : Babarpur","Exp: 15yrs","Mobile No:8686868686","2400"},
                    {"Doctor Name : Rishabh Porwal","Hospital Address : Delhi","Exp: 10yrs","Mobile No:8585858585","2300"},
                    {"Doctor Name : Ritika Wason","Hospital Address : Delhi","Exp: 5yrs","Mobile No:8484848484","2200"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Ankush Singh","Hospital Address : Bhopal","Exp: 11yrs","Mobile No:8383838383","3500"},
                    {"Doctor Name : Nitin Patidar","Hospital Address : Indore","Exp: 10yrs","Mobile No:8282828282","3400"},
                    {"Doctor Name : Mangal Patidar","Hospital Address : Madhya Pradesh","Exp: 9yrs","Mobile No:8181818181","3300"},
                    {"Doctor Name : Anand Dixit","Hospital Address : Sujalpur","Exp: 8yrs","Mobile No:8080808080","3200"},
                    {"Doctor Name : Sravan Porwal","Hospital Address : Kanpur","Exp: 7yrs","Mobile No:7979797979","3100"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Rishi Porwal","Hospital Address : Noida","Exp: 15yrs","Mobile No:7878787878","5000"},
                    {"Doctor Name : Nitin Porwal","Hospital Address : Chennai","Exp: 13yrs","Mobile No:7777777777","4500"},
                    {"Doctor Name : Priyanka Porwal","Hospital Address : Babarpur","Exp: 11yrs","Mobile No:7676767676","4000"},
                    {"Doctor Name : Shivani Porwal","Hospital Address : Ajitmal","Exp: 10yrs","Mobile No:7575757575","3500"},
                    {"Doctor Name : Saumya Bansal","Hospital Address : Delhi","Exp: 8yrs","Mobile No:7474747474","3000"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details={};
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewBMCartTitle);
        btn = findViewById(R.id.buttonBMCartCheckout);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
           doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


       btn.setOnClickListener(new View.OnClickListener()
       {
           public void onClick(View view)
           {
               startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
           }
       });

        list=new ArrayList();
        for(int i=0;i<doctor_details.length;i++)
        {
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);

       lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
               it.putExtra("text1",title);
               it.putExtra("text2",doctor_details[i][0]);
               it.putExtra("text3",doctor_details[i][1]);
               it.putExtra("text4",doctor_details[i][3]);
               it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
           }
       });

    }
}