package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class playActivity extends AppCompatActivity {
    String[] question_list = {"Что такое сила тяжести и как она влияет на объекты на Земле?",
            "Почему небо голубое"
            ,"Что такое электрический ток и как он течет в проводниках?",
            "Что такое энергия и какие виды энергии существуют?",
            "Почему предметы плавают или тонут в воде?"
            ,"Как работает зеркало?"
            ,"Почему мы видим молнию раньше, чем слышим гром?"
            ,"Что такое температура и как она измеряется?"
            ,"Что такое давление и как оно действует на объекты?",
            "Как работает магнит?"
    };
    String[] choose_list = {"Сила тяжести притягивает объекты к Земле, заставляя их падать.","Сила тяжести заставляет объекты двигаться по прямой линии."," Сила тяжести действует только на большие объекты.","Сила тяжести заставляет объекты подниматься вверх.",
            "Синий свет рассеивается атмосферой больше других цветов.","Небо голубое из-за отражения воды.","Небо голубое потому, что солнце излучает голубой свет.","Небо голубое из-за присутствия кислорода.",
            "Электрический ток — это поток электронов через проводник под действием напряжения.","Электрический ток — это поток протонов через проводник.","Электрический ток движется только в одном направлении всегда.","Электрический ток — это вид энергии, передаваемой волнами.",
            "Энергия — способность совершать работу. Виды: кинетическая, потенциальная, тепловая, электрическая, химическая, ядерная.","Энергия — это вещество, которое можно хранить в контейнерах.","Виды энергии: световая, материальная, жидкостная.","Энергия не может превращаться из одного вида в другой.",
            "Предметы плавают, если их плотность меньше плотности воды, и тонут, если больше.","Предметы плавают, если их масса больше массы воды.","редметы тонут, если они слишком легкие.","Все предметы плавают, если они маленькие.",
            "Зеркало отражает свет, позволяя видеть отражение объектов." ,"Зеркало поглощает свет, создавая изображение.","Зеркало излучает собственный свет для создания изображения.","Зеркало работает за счет электромагнитных волн.",
            "Молния всегда происходит раньше грома.","Звук грома распространяется только в ночное время.","Свет быстрее звука, поэтому молнию видно раньше.","Молния и гром не связаны друг с другом.",
            "Температура — мера средней кинетической энергии молекул, измеряется термометром.","Температура — это количество тепла в объекте.","Температура измеряется только с помощью барометра.","Температура — это уровень света в окружающей среде.",
            "Давление — сила на единицу площади, действует на объекты, например, воздух создает атмосферное давление. ","Давление — это температура, воздействующая на объекты.","Давление не имеет никакого физического воздействия на объекты.","Давление измеряется в литрах.",
            "Магнит создает магнитное поле, притягивая или отталкивая магнитные материалы.","Магнит создает электрическое поле для притяжения объектов.","Магнит работает только в отсутствие гравитации.","Магнит привлекает все виды материалов.",
            "1","2","4","5","6","7","8","9","10"
    };
    String[] correct_list = {"Сила тяжести притягивает объекты к Земле, заставляя их падать.","Синий свет рассеивается атмосферой больше других цветов.","Электрический ток — это поток электронов через проводник под действием напряжения","Энергия — способность совершать работу. Виды: кинетическая, потенциальная, тепловая, электрическая, химическая, ядерная.","Предметы плавают, если их плотность меньше плотности воды, и тонут, если больше.","Зеркало отражает свет, позволяя видеть отражение объектов.","Свет быстрее звука, поэтому молнию видно раньше.","Температура — мера средней кинетической энергии молекул, измеряется термометром.","Давление — сила на единицу площади, действует на объекты, например, воздух создает атмосферное давление. ","Магнит создает магнитное поле, притягивая или отталкивая магнитные материалы.","10"};


    TextView cpt_question , text_question;
    Button btn_choose1 , btn_choose2 , btn_choose3 , btn_choose4 , btn_next,check1 ;

    private boolean checked = false;
    private boolean questionAnswered = false;
    int currentQuestion =  0  ;
    int scorePlayer =  0  ;
    boolean isclickBtn = false;
    String valueChoose = "";
    Button btn_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        cpt_question = findViewById(R.id.cpt_question);
        text_question = findViewById(R.id.text_question);

        btn_choose1 = findViewById(R.id.btn_choose1);
        btn_choose2 = findViewById(R.id.btn_choose2);
        btn_choose3 = findViewById(R.id.btn_choose3);
        btn_choose4 = findViewById(R.id.btn_choose4);
        btn_next = findViewById(R.id.btn_next);
        check1 = findViewById(R.id.check1);


        findViewById(R.id.image_back).setOnClickListener(
                a -> finish()
        );
        remplirData();
        btn_next.setOnClickListener(view -> {
            new Handler().postDelayed(() -> {
                if (valueChoose.isEmpty()) {
                    Toast.makeText(playActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (currentQuestion != question_list.length - 1) {
                    currentQuestion = currentQuestion + 1;
                    remplirData();
                    valueChoose = "";
                    btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
                    btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
                    btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
                    btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);
                } else {
                    Intent intent = new Intent(playActivity.this, ResulteActivity.class);
                    intent.putExtra("Result", scorePlayer);
                    startActivity(intent);
                    finish();
                }

            }, 200);
        });

        check1.setOnClickListener(
                view -> {
                    if (isclickBtn) {
                        isclickBtn = false;

                        if (!valueChoose.equals(correct_list[currentQuestion])) {

                            Toast.makeText(playActivity.this, "Incorrect. Correct answer is: " + correct_list[currentQuestion], Toast.LENGTH_LONG).show();
                            btn_click.setBackgroundResource(R.drawable.background_btn_erreur);
                        } else {

                            Toast.makeText(playActivity.this, "Correct", Toast.LENGTH_LONG).show();
                            btn_click.setBackgroundResource(R.drawable.background_btn_correct);
                            scorePlayer++;
                        }


                    } else {
                        Toast.makeText(playActivity.this, "Enter the answer", Toast.LENGTH_LONG).show();
                    }

                }
        );
    }


    void remplirData(){
        cpt_question.setText((currentQuestion+1) + "/" + question_list.length);
        text_question.setText(question_list[currentQuestion]);

        btn_choose1.setText(choose_list[4 * currentQuestion]);
        btn_choose2.setText(choose_list[4 * currentQuestion+1]);
        btn_choose3.setText(choose_list[4 * currentQuestion+2]);
        btn_choose4.setText(choose_list[4 * currentQuestion+3]);

    }

    public void ClickChoose(View view) {
        btn_click = (Button)view;

        if (isclickBtn) {
            btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);
        }
        chooseBtn();


    }
    void chooseBtn() {
        btn_click.setBackgroundResource(R.drawable.background_btn_choose_color);
        isclickBtn = true;
        valueChoose = btn_click.getText().toString();
    }
}