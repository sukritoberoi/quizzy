package com.example.quizzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView question,questions_completed;
    RadioButton a,b,c,radioButton;
    ProgressBar progressbar;
    Button button;
    RadioGroup checkboxess;
    int progress=0,count=0,i,score=0;
    String str="2016";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question= (TextView) findViewById(R.id.question);
        questions_completed= (TextView) findViewById(R.id.questionscompleted);

        button = (Button) findViewById(R.id.next);

        checkboxess=(RadioGroup) findViewById(R.id.optionss);

        a = (RadioButton) findViewById(R.id.option_a);
        b = (RadioButton) findViewById(R.id.option_b);
        c = (RadioButton) findViewById(R.id.option_c);

        progressbar=(ProgressBar) findViewById(R.id.progressbar);
        progressbar.setProgress(0);
        progressbar.setMax(10);

        String[] string_text = getResources().getStringArray(R.array.text);

        TypedArray string_questions = getResources().obtainTypedArray(R.array.all_questions);

        int length = string_questions.length();
        String[][] array = new String[length][];
        for(i=0;i<length;i++)
        {
            int id = string_questions.getResourceId(i, 0);
            if (id>0) {
                array[i] = getResources().getStringArray(id);
            }
        }
        string_questions.recycle();

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(count==9)
                {
                    Intent myIntent = new Intent(MainActivity.this, popup.class);
                    MainActivity.this.startActivity(myIntent);
                }

                int selectedId=checkboxess.getCheckedRadioButtonId();
                radioButton=(RadioButton)findViewById(selectedId);
                if(radioButton.getText().equals(str))
                    score+=1;
                checkboxess.clearCheck();

                for(i=0;i<=4;i++)
                {
                    if(i==0)
                        question.setText(array[count][i]);
                    if(i==1)
                        a.setText(array[count][i]);
                    if(i==2)
                        b.setText(array[count][i]);
                    if(i==3)
                        c.setText(array[count][i]);
                    if(i==4)
                        str=array[count][i];
                }

                questions_completed.setText(string_text[count]);

                if(progress<10)
                    progress+=1;
                progressbar.setProgress(progress);

                Toast.makeText(MainActivity.this, "Your score is "+score, Toast.LENGTH_SHORT).show();

                count+=1;

                if(count==9)
                    button.setText(getResources().getString(R.string.button_text_end));



            }
        });

    }

}