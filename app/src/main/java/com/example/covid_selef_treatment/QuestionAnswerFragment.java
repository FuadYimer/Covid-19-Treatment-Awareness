package com.example.covid_selef_treatment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionAnswerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionAnswerFragment extends Fragment implements View.OnClickListener {

    private Context mContext;
    //private Activity mActivity;
    private RelativeLayout mRelativeLayout;

    private ImageButton imageButton , imageButton2 ,imageButton3 ,imageButton4 ,imageButton5 ,imageButton6 ,imageButton7 ,imageButton8
            ,imageButton9 ,imageButton10 ,imageButton11 ,imageButton12,imageButton13 ,imageButton14 ,imageButton15 ,imageButton16;
    private LinearLayout linearLayout , linearLayout2 ,linearLayout3 , linearLayout4, linearLayout5 , linearLayout6 , linearLayout7
            , linearLayout8 , linearLayout9 , linearLayout10 , linearLayout11 , linearLayout12 , linearLayout13 , linearLayout14 , linearLayout15 , linearLayout16;

    TextView textView, textView2 , textView3 , textView4, textView5  , textView6 , textView7
            , textView8 , textView9 , textView10 , textView11  , textView12 , textView13 , textView14 , textView15 , textView16;
    String htmlString;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuestionAnswerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionAnswerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionAnswerFragment newInstance(String param1, String param2) {
        QuestionAnswerFragment fragment = new QuestionAnswerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_question_answer, container, false);
        // Get the widgets reference from XML layout

        // Dear fuad optimize the code here
        imageButton = view.findViewById(R.id.btn_showhide);
        linearLayout  = view.findViewById(R.id.layout_detail);
        linearLayout.setVisibility(View.GONE);
        imageButton.setBackgroundResource(R.drawable.display_block);
        textView = view.findViewById(R.id.detail_1);


        imageButton2 = view.findViewById(R.id.btn_showhide2);
        linearLayout2  = view.findViewById(R.id.layout_detail2);
        linearLayout2.setVisibility(View.GONE);
        imageButton2.setBackgroundResource(R.drawable.display_block);
        textView2 = view.findViewById(R.id.detail_2);


        imageButton3 = view.findViewById(R.id.btn_showhide3);
        linearLayout3  = view.findViewById(R.id.layout_detail3);
        linearLayout3.setVisibility(View.GONE);
        imageButton3.setBackgroundResource(R.drawable.display_block);
        textView3 = view.findViewById(R.id.detail_3);

        imageButton4 = view.findViewById(R.id.btn_showhide4);
        linearLayout4  = view.findViewById(R.id.layout_detail4);
        linearLayout4.setVisibility(View.GONE);
        imageButton4.setBackgroundResource(R.drawable.display_block);
        textView4 = view.findViewById(R.id.detail_4);


        imageButton5 = view.findViewById(R.id.btn_showhide5);
        linearLayout5  = view.findViewById(R.id.layout_detail5);
        linearLayout5.setVisibility(View.GONE);
        imageButton5.setBackgroundResource(R.drawable.display_block);
        textView5 = view.findViewById(R.id.detail_5);

        imageButton6 = view.findViewById(R.id.btn_showhide6);
        linearLayout6  = view.findViewById(R.id.layout_detail6);
        linearLayout6.setVisibility(View.GONE);
        imageButton6.setBackgroundResource(R.drawable.display_block);
        textView6 = view.findViewById(R.id.detail_6);

        imageButton7 = view.findViewById(R.id.btn_showhide7);
        linearLayout7  = view.findViewById(R.id.layout_detail7);
        linearLayout7.setVisibility(View.GONE);
        imageButton7.setBackgroundResource(R.drawable.display_block);
        textView7 = view.findViewById(R.id.detail_7);

        imageButton8 = view.findViewById(R.id.btn_showhide8);
        linearLayout8  = view.findViewById(R.id.layout_detail8);
        linearLayout8.setVisibility(View.GONE);
        imageButton8.setBackgroundResource(R.drawable.display_block);
        textView8 = view.findViewById(R.id.detail_8);

        imageButton9 = view.findViewById(R.id.btn_showhide9);
        linearLayout9  = view.findViewById(R.id.layout_detail9);
        linearLayout9.setVisibility(View.GONE);
        imageButton9.setBackgroundResource(R.drawable.display_block);
        textView9 = view.findViewById(R.id.detail_9);

        imageButton10 = view.findViewById(R.id.btn_showhide10);
        linearLayout10  = view.findViewById(R.id.layout_detail10);
        linearLayout10.setVisibility(View.GONE);
        imageButton10.setBackgroundResource(R.drawable.display_block);
        textView10 = view.findViewById(R.id.detail_10);

        imageButton11 = view.findViewById(R.id.btn_showhide11);
        linearLayout11  = view.findViewById(R.id.layout_detail11);
        linearLayout11.setVisibility(View.GONE);
        imageButton11.setBackgroundResource(R.drawable.display_block);
        textView11 = view.findViewById(R.id.detail_11);

        imageButton12 = view.findViewById(R.id.btn_showhide12);
        linearLayout12  = view.findViewById(R.id.layout_detail12);
        linearLayout12.setVisibility(View.GONE);
        imageButton12.setBackgroundResource(R.drawable.display_block);
        textView12 = view.findViewById(R.id.detail_12);

        imageButton13 = view.findViewById(R.id.btn_showhide13);
        linearLayout13  = view.findViewById(R.id.layout_detail13);
        linearLayout13.setVisibility(View.GONE);
        imageButton13.setBackgroundResource(R.drawable.display_block);
        textView13 = view.findViewById(R.id.detail_13);

        imageButton14 = view.findViewById(R.id.btn_showhide14);
        linearLayout14  = view.findViewById(R.id.layout_detail14);
        linearLayout14.setVisibility(View.GONE);
        imageButton14.setBackgroundResource(R.drawable.display_block);
        textView14 = view.findViewById(R.id.detail_14);

        imageButton15 = view.findViewById(R.id.btn_showhide15);
        linearLayout15  = view.findViewById(R.id.layout_detail15);
        linearLayout15.setVisibility(View.GONE);
        imageButton15.setBackgroundResource(R.drawable.display_block);
        textView15 = view.findViewById(R.id.detail_15);

        imageButton16 = view.findViewById(R.id.btn_showhide16);
        linearLayout16  = view.findViewById(R.id.layout_detail16);
        linearLayout16.setVisibility(View.GONE);
        imageButton16.setBackgroundResource(R.drawable.display_block);
        textView16 = view.findViewById(R.id.detail_16);


        imageButton.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton6.setOnClickListener(this);
        imageButton7.setOnClickListener(this);
        imageButton8.setOnClickListener(this);
        imageButton9.setOnClickListener(this);
        imageButton10.setOnClickListener(this);
        imageButton11.setOnClickListener(this);
        imageButton12.setOnClickListener(this);
        imageButton13.setOnClickListener(this);
        imageButton14.setOnClickListener(this);
        imageButton15.setOnClickListener(this);
        imageButton16.setOnClickListener(this);


        return view;
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_showhide:
                htmlString = "√ Coronaviruses are a large family of viruses which may cause illness in animals or humans.  In humans, several coronaviruses are known to cause respiratory infections ranging from the common cold to more severe diseases such as Middle East Respiratory Syndrome (MERS) and Severe Acute Respiratory Syndrome (SARS). The most recently discovered coronavirus causes coronavirus disease COVID-19.";
                if(linearLayout.getVisibility()==View.GONE)
                {
                    textView.setText(Html.fromHtml(htmlString));
                    linearLayout.setVisibility(View.VISIBLE);
                    imageButton.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout.setVisibility(View.GONE);
                    imageButton.setBackgroundResource(R.drawable.display_block);
                }
                break;
            case R.id.btn_showhide2:
                htmlString  =  "♦ COVID-19 is the infectious disease caused by the most recently discovered coronavirus. This new virus and disease were unknown before the outbreak began in Wuhan, China, in December 2019. COVID-19 is now a pandemic affecting many countries globally." ;
                if(linearLayout2.getVisibility()==View.GONE)
                {
                    textView2.setText(Html.fromHtml(htmlString));
                    linearLayout2.setVisibility(View.VISIBLE);
                    imageButton2.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout2.setVisibility(View.GONE);
                    imageButton2.setBackgroundResource(R.drawable.display_block);
                }
                break;
            case R.id.btn_showhide3:
                htmlString  =  "<ul>\n" +
                        "♦ The most common symptoms of COVID-19 are fever, dry cough, and tiredness. Other symptoms " +
                        "that are less common and may affect some patients include aches and pains, nasal congestion, headache, " +
                        "conjunctivitis, sore throat, diarrhea, loss of taste or smell or a rash on skin or discoloration of fingers or toes. These symptoms are usually mild and begin gradually. Some people become infected but only have very mild symptoms.<br/>" +
                        "♦ Most people (about 80%) recover from the disease without needing hospital treatment. " +
                        "Around 1 out of every 5 people who gets COVID-19 becomes seriously ill and develops difficulty " +
                        "breathing. Older people, and those with underlying medical problems like high blood pressure," +
                        " heart and lung problems, diabetes, or cancer, are at higher risk of developing serious illness.  " +
                        "However, anyone can catch COVID-19 and become seriously ill.  People of all ages who experience fever and/or  cough associated withdifficulty breathing/shortness of breath, chest pain/pressure, or loss of speech or movement should seek medical attention immediately." +
                        "If possible, it is recommended to call the health care provider or facility first, so the patient can be directed to the right clinic."+
                        "</ul>" ;

                if(linearLayout3.getVisibility()==View.GONE)
                {
                    textView3.setText(Html.fromHtml(htmlString));
                    linearLayout3.setVisibility(View.VISIBLE);
                    imageButton3.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout3.setVisibility(View.GONE);
                    imageButton3.setBackgroundResource(R.drawable.display_block);
                }
                break;
            case R.id.btn_showhide4:
                htmlString  =  "<ul>\n" +
                        " ♦ If you have minor symptoms, such as a slight cough or a mild fever, there is generally no need to seek medical care. Stay at home, self-isolate and monitor your symptoms. Follow national guidance on self-isolation.<br/>" +
                        " ♦ However, if you live in an area with malaria or dengue fever it is important that you do not ignore symptoms of fever.  Seek medical help.  When you attend the health facility wear a mask if possible, keep at least 1 metre distance from other people and do not touch surfaces with your hands. " +
                        "If it is a child who is sick help the child stick to this advice.<br/>"+
                        " ♦ Seek immediate medical care if you have difficulty breathing or pain/pressure in the chest. If possible, call your health care provider in advance, so he/she can direct you to the right health facility. <br/>"+
                        "</ul>" ;

                if(linearLayout4.getVisibility()==View.GONE)
                {
                    textView4.setText(Html.fromHtml(htmlString));
                    linearLayout4.setVisibility(View.VISIBLE);
                    imageButton4.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout4.setVisibility(View.GONE);
                    imageButton4.setBackgroundResource(R.drawable.display_block);
                }

                break;

            case R.id.btn_showhide5:
                htmlString  =  "<ul>\n" +
                        "♦ People can catch COVID-19 from others who have the virus. The disease spreads primarily from person to person through small droplets from the nose or mouth, which are expelled when a person with COVID-19 coughs, sneezes, or speaks. " +
                        "These droplets are relatively heavy, do not travel far and quickly sink to the ground. People can catch COVID-19 if they breathe in these droplets from a person infected with the virus.  This is why it is important to stay at least 1 meter) away from others. These droplets can land on objects and surfaces around the person such as tables, doorknobs and handrails.  People can become infected by touching these objects or surfaces, then touching their eyes, nose or mouth.  This is why it is important to wash your hands regularly with soap and water or clean with alcohol-based hand rub.<br/>" +
                        "♦ WHO is assessing ongoing research on the ways that COVID-19 is spread and will continue to share updated findings.    "+
                        "</ul>" ;

                if(linearLayout5.getVisibility()==View.GONE)
                {
                    textView5.setText(Html.fromHtml(htmlString));
                    linearLayout5.setVisibility(View.VISIBLE);
                    imageButton5.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout5.setVisibility(View.GONE);
                    imageButton5.setBackgroundResource(R.drawable.display_block);
                }

                break;
            case R.id.btn_showhide6:
                htmlString  =  "<ul>\n" +
                        " ♦ COVID-19 is mainly spread through respiratory droplets expelled by someone who is coughing or has other symptoms such as fever or tiredness. Many people with COVID-19 experience only mild symptoms. " +
                        "This is particularly true in the early stages of the disease. It is possible to catch COVID-19 from someone who has just a mild cough and does not feel ill.<br/>"+
                        " ♦ Some reports have indicated that people with no symptoms can transmit the virus. It is not yet known how often it happens. WHO is assessing ongoing research on the topic and will continue to share updated findings."+
                        "</ul>" ;

                if(linearLayout6.getVisibility()==View.GONE)
                {
                    textView6.setText(Html.fromHtml(htmlString));
                    linearLayout6.setVisibility(View.VISIBLE);
                    imageButton6.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout6.setVisibility(View.GONE);
                    imageButton6.setBackgroundResource(R.drawable.display_block);
                }

                break;
            case R.id.btn_showhide7:
                htmlString  =  "<ul>\n" +
                        "♦ Practicing hand and respiratory hygiene is important at ALL times and is the best way to protect others and yourself.<br/>"+
                        "♦ When possible maintain at least a 1 meter distance between yourself and others. This is especially important if you are standing by someone who is coughing or sneezing.  " +
                        "Since some infected persons may not yet be exhibiting symptoms or their symptoms may be mild, maintaining a physical distance with everyone is a good idea if you are in an area where COVID-19 is circulating. "+
                        "</ul>" ;

                if(linearLayout7.getVisibility()==View.GONE)
                {
                    textView7.setText(Html.fromHtml(htmlString));
                    linearLayout7.setVisibility(View.VISIBLE);
                    imageButton7.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout7.setVisibility(View.GONE);
                    imageButton7.setBackgroundResource(R.drawable.display_block);
                }

                break;
            case R.id.btn_showhide8:
                htmlString  =  "<ul>\n" +
                        "♦ If you have been in close contact with someone with COVID-19, you may be infected.<br/>"+
                        "♦ Close contact means that you live with or have been in settings of less than 1 metre from those who have the disease. " +
                        "In these cases, it is best to stay at home.<br/>" +
                        "♦ However, if you live in an area with malaria or dengue fever it is important that you do not ignore symptoms of fever. Seek medical help. When you attend the health facility wear a mask if possible, keep at least 1 metre distant from other people and do not touch surfaces with your hands. " +
                        "If it is a child who is sick help the child stick to this advice.<br/>" +
                        "♦ If you do <b>not</b> live in an area with malaria or dengue fever please do the following:<br/>" +
                        "<ul>" +
                        "    √ If you become ill, even with very mild symptoms you must self-isolate<br/>" +
                        "    √ Even if you don’t think you have been exposed to COVID-19 but develop symptoms, then self-isolate and monitor yourself<br/>" +
                        "    √ You are more likely to infect others in the early stages of the disease when you just have mild symptoms, therefore early self-isolation is very important.<br/>" +
                        "    √ If you do not have symptoms, but have been exposed to an infected person, self-quarantine for 14 days.<br/ " +
                        "</ul>" +
                        "♦ If you have definitely had COVID-19 (confirmed by a test) self-isolate for 14 days even after symptoms have disappeared as a precautionary measure – it is not yet known exactly how long people remain infectious after they have recovered. Follow national advice on self-isolation."+
                        "</ul>" ;

                if(linearLayout8.getVisibility()==View.GONE)
                {
                    textView8.setText(Html.fromHtml(htmlString));
                    linearLayout8.setVisibility(View.VISIBLE);
                    imageButton8.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout8.setVisibility(View.GONE);
                    imageButton8.setBackgroundResource(R.drawable.display_block);
                }

                break;
            case R.id.btn_showhide9:
                htmlString  =  "<ul>\n" +
                        "♦ Self-isolation is an important measure taken by those who have COVID-19 symptoms to avoid infecting others in the community, including family members.<br/>"+
                        "♦ Self-isolation is when a person who is experiencing fever, cough or other COVID-19 symptoms stays at home and does not go to work, school or public places. This can be voluntarily or based on his/her health care provider’s recommendation. However, if you live in an area with malaria or dengue fever it is important that you do not ignore symptoms of fever. Seek medical help. When you attend the health facility wear a mask if possible, keep at least 1 metre distant from other people and do not touch surfaces with your hands. If it is a child who is sick help the child stick to this advice.<br/>" +
                        "If you do not live in an area with malaria or dengue fever please do the following: <br/>" +
                        "<ul> +" +
                        "    √  If a person is in self-isolation, it is because he/she is ill but not severely ill (requiring medical attention)<br/>" +
                        "    √  Have a large, well-ventilated with hand-hygiene and toilet facilities <br/>" +
                        "    √  If this is not possible, place beds at least 1 metre apart<br/>" +
                        "    √  Keep at least 1 metre from others, even from your family members<br/>" +
                        "    √  Monitor your symptoms daily<br/>" +
                        "    √  Isolate for 14 days, even if you feel healthy<br/>" +
                        "    √  If you develop difficulty breathing, contact your healthcare provider immediately – call them first if possible<br/>" +
                        "    √  Stay positive and energized by keeping in touch with loved ones by phone or online, and by exercising yourself at home.<br/>" +
                        "</ul>"+
                        "</ul>" ;

                if(linearLayout9.getVisibility()==View.GONE)
                {
                    textView9.setText(Html.fromHtml(htmlString));
                    linearLayout9.setVisibility(View.VISIBLE);
                    imageButton9.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout9.setVisibility(View.GONE);
                    imageButton9.setBackgroundResource(R.drawable.display_block);
                }

                break;
            case R.id.btn_showhide10:
                htmlString  =  "<ul>\n" +
                        "♦ Quarantine means restricting activities or separating <u>people who are not ill</u> themselves but may have been exposed to COVID-19. The goal is to prevent spread of the disease at the time when people just develop symptoms.<br/>"+
                        "♦ Isolation means separating <u> people who are ill </u> with symptoms of COVID-19 and may be infectious to prevent the spread of the disease.<br/>" +
                        "♦ Physical distancing means being physically apart. WHO recommends keeping at least 1-metre distance from others. This is a general measure that <u>everyone</u> should take even if they are well with no known exposure to COVID-19. " +
                        "</ul>" ;

                if(linearLayout10.getVisibility()==View.GONE)
                {
                    textView10.setText(Html.fromHtml(htmlString));
                    linearLayout10.setVisibility(View.VISIBLE);
                    imageButton10.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout10.setVisibility(View.GONE);
                    imageButton10.setBackgroundResource(R.drawable.display_block);
                }

                break;
            case R.id.btn_showhide11:
                htmlString  =  "<ul>\n" +
                        "♦ To self-quarantine means to separate yourself from others because you have been exposed to someone with COVID-19 even though you, yourself, do not have symptoms.During self-quarantine you monitor yourself for symptoms.  The goal of the self-quarantine is to prevent transmission. " +
                        " Since people who become ill with COVID-19 can infect people immediately self-quarantine can prevent some infections from happening.<br/>"+
                        "♦ In this case <br/>" +
                        "<ul>" +
                        "  √ Have a large, well-ventilated single room with hand hygiene and toilet facilities<br/>" +
                        "  √ If this is not available place beds at least 1 metre apart.<br/" +
                        "  √ Keep at least 1-metre distance from others, even from your family members.<br/" +
                        "  √ Monitor your symptoms daily.<br/" +
                        "  √ Self-quarantine for 14 days, even if you feel healthy.<br/" +
                        "  √ If you develop difficulty breathing, contact your healthcare provider immediately – call them first if possible.<br/" +
                        "  √ Stay positive and energized by keeping in touch with loved ones by phone or online, and by exercising yourself at home.<br/" +
                        "</ul>" +
                        "♦ However, if you live in an area with malaria or dengue fever it is important that you do not ignore symptoms of fever.  " +
                        "Seek medical help.  When you attend the health facility wear a mask if possible, keep at least 1 metre distant from other people and do not touch surfaces with your hands. If it is a child who is sick help the child stick to this advice. " +
                        "</ul>" ;

                if(linearLayout11.getVisibility()==View.GONE)
                {
                    textView11.setText(Html.fromHtml(htmlString));
                    linearLayout11.setVisibility(View.VISIBLE);
                    imageButton11.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout11.setVisibility(View.GONE);
                    imageButton11.setBackgroundResource(R.drawable.display_block);
                }

                break;
            case R.id.btn_showhide12:
                htmlString  =  "<ul>\n" +
                        "♦ Research indicates that children and adolescents are just as likely to become infected as any other age group and can spread the disease.<br/>"+
                        "♦ Evidence to date suggests that children and young adults are less likely to get severe disease, but severe cases can still happen in these age groups.<br/>" +
                        "♦ Children and adults should follow the same guidance on self-quarantine and self-isolation if there is a risk they have been exposed or are showing symptoms. It is particularly important that children avoid contact with older people and others who are at risk of more severe disease." +
                        "</ul>" ;

                if(linearLayout12.getVisibility()==View.GONE)
                {
                    textView12.setText(Html.fromHtml(htmlString));
                    linearLayout12.setVisibility(View.VISIBLE);
                    imageButton12.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout12.setVisibility(View.GONE);
                    imageButton12.setBackgroundResource(R.drawable.display_block);
                }

                break;
            case R.id.btn_showhide13:
                htmlString  =  "<ul>\n" +
                        "♦ Stay aware of the latest information on the COVID-19 outbreak, available on the WHO website and through your national and local public health authority. Most countries around the world have seen cases of COVID-19 and many are experiencing outbreaks. Authorities in China and some other countries have succeeded in slowing their outbreaks. " +
                        "However, the situation is unpredictable so check regularly for the latest news.<br/>" +
                        "♦ You can reduce your chances of being infected or spreading COVID-19 by taking some simple precautions:<br>" +
                        "<ul>" +
                        "   √ Regularly and thoroughly clean your hands with an alcohol-based hand rub or wash them with soap and water. Why? Washing your hands with soap and water or using alcohol-based hand rub kills viruses that may be on your hands.<br/>" +
                        "   √ Maintain at least 1 metre distance between yourself and others. Why? When someone coughs, sneezes, or speaks they spray small liquid droplets from their nose or mouth which may contain virus. If you are too close, you can breathe in the droplets, including the COVID-19 virus if the person has the disease.<br/>" +
                        "   √ Avoid going to crowded places. Why? Where people come together in crowds, you are more likely to come into close contact with someone that has COVID-19 and it is more difficult to maintain physical distance of 1 metre.<br/>" +
                        "   √ Avoid touching eyes, nose and mouth. Why? Hands touch many surfaces and can pick up viruses. Once contaminated, hands can transfer the virus to your eyes, nose or mouth. From there, the virus can enter your body and infect you.<br/>" +
                        "   √ Make sure you, and the people around you, follow good respiratory hygiene. This means covering your mouth and nose with your bent elbow or tissue when you cough or sneeze. Then dispose of the used tissue immediately and wash your hands. Why? Droplets spread virus. By following good respiratory hygiene, you protect the people around you from viruses such as cold, flu and COVID-19.<br/>" +
                        "   √ Stay home and self-isolate even with minor symptoms such as cough, headache, mild fever, until you recover. Have someone bring you supplies. If you need to leave your house, wear a mask to avoid infecting others. Why? Avoiding contact with others will protect them from possible COVID-19 and other viruses.<br/>" +
                        "   √ If you have a fever, cough and difficulty breathing, seek medical attention, but call by telephone in advance if possible and follow the directions of your local health authority. Why? National and local authorities will have the most up to date information on the situation in your area. Calling in advance will allow your health care provider to quickly direct you to the right health facility. This will also protect you and help prevent spread of viruses and other infections.<br/>" +
                        "   √ Keep up to date on the latest information from trusted sources, such as WHO or your local and national health authorities. Why? Local and national authorities are best placed to advise on what people in your area should be doing to protect themselves." +
                        "</ul> "+
                        "</ul>" ;

                if(linearLayout13.getVisibility()==View.GONE)
                {
                    textView13.setText(Html.fromHtml(htmlString));
                    linearLayout13.setVisibility(View.VISIBLE);
                    imageButton13.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout13.setVisibility(View.GONE);
                    imageButton13.setBackgroundResource(R.drawable.display_block);
                }

                break;
            case R.id.btn_showhide14:
                htmlString  =  "<ul>\n" +
                        "♦ While some western, traditional or home remedies may provide comfort and alleviate symptoms of mild COVID-19, there are no medicines that have been shown to prevent or cure the disease. " +
                        "WHO does not recommend self-medication with any medicines, including antibiotics, as a prevention or cure for COVID-19. However, there are several ongoing clinical trials of both western and traditional medicines. WHO is coordinating efforts to develop vaccines and medicines to prevent and treat COVID-19 and will continue to provide updated information as soon research results become available.<br/>" +
                        "♦ The most effective ways to protect yourself and others against COVID-19 are to:<br>" +
                        "<ul>" +
                        "   √ Clean your hands frequently and thoroughly<br/>" +
                        "   √ Avoid touching your eyes, mouth and nose<br/>" +
                        "   √ Cover your cough with the bend of elbow or tissue. If a tissue is used, discard it immediately and wash your hands.<br/>" +
                        "   √ Maintain a distance of at least 1 metre from others.  "+
                        "</ul> "+
                        "</ul>" ;

                if(linearLayout14.getVisibility()==View.GONE)
                {
                    textView14.setText(Html.fromHtml(htmlString));
                    linearLayout14.setVisibility(View.VISIBLE);
                    imageButton14.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout14.setVisibility(View.GONE);
                    imageButton14.setBackgroundResource(R.drawable.display_block);
                }

                break;
            case R.id.btn_showhide15:
                htmlString  =  "<ul>\n" +
                        "♦ Currently, there is not enough evidence for or against the use of masks (medical or other) in healthy individuals in the wider community. However, WHO is actively studying the rapidly evolving science on masks and continuously updates its guidance.<br/>" +
                        "♦ Medical masks are recommended primarily in health care settings, but can be considered in other circumstances (see below). Medical masks should be combined with other key infection prevention and control measures such as hand hygiene and physical distancing.<br/> " +
                        "<b>Healthcare workers</b> <br/> <b>Why?</b> Medical masks and respirators such as N95, FFP2 or equivalent are recommended for and should be reserved for, healthcare workers while giving care to patients. Close contact with people with suspected or confirmed COVID-19 and their surrounding environment are the main routes of transmission, which means healthcare workers are the most exposed.<br/>"+
                        " <b>People who are sick and exhibiting symptoms of COVID-19 </b> <br/> <b>Why?</b> Anyone who is sick, with mild symptoms such as muscle aches, slight cough, sore throat or fatigue, should isolate at home and use a medical mask according to WHO’s recommendation on home care of patients with suspected COVID-19. Coughing, sneezing or talking can generate droplets that cause can spread the infection. These droplets can reach the face of others nearby and land on the surrounding environment. If an infected person coughs, sneezes, or talks while wearing a medical mask, this can help to protect those nearby from infection." +
                        " If a sick person needs to go to a health facility they should wear a medical mask.<br/>" +
                        "<b>Anyone taking care of a person at home who is sick with COVID-199 </b> <br/> <b>Why?</b> Those caring for individuals who are sick with COVID-19 should wear a medical mask for protection. Again, close, frequent and prolonged contact with someone with COVID-19 puts caretakers at high risk. National decision makers may also choose to recommend medical mask use for certain individuals using a risk-based approach. " +
                        "This approach takes into consideration the purpose of the mask, risk of exposure and vulnerability of the wearer, the setting, the feasibility of use and the types of masks to be considered."+
                        "</ul>" ;

                if(linearLayout15.getVisibility()==View.GONE)
                {
                    textView15.setText(Html.fromHtml(htmlString));
                    linearLayout15.setVisibility(View.VISIBLE);
                    imageButton15.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout15.setVisibility(View.GONE);
                    imageButton15.setBackgroundResource(R.drawable.display_block);
                }

                break;
            case R.id.btn_showhide16:
                htmlString  =  "<ul>\n" +
                        "♦ If you choose to wear a mask:<br/>" +
                        "   √ Before touching the mask, clean hands with an alcohol-based hand rub or soap and water<br/>" +
                        "   √ Take the mask and inspect it for tears or holes.<br/>" +
                        "   √ Orient which side is the top side (where the metal strip is).<br/>" +
                        "   √ Ensure the proper side of the mask faces outwards (the coloured side).<br/>" +
                        "   √ Place the mask to your face. Pinch the metal strip or stiff edge of the mask so it moulds to the shape of your nose.<br/>" +
                        "   √ Pull down the mask’s bottom so it covers your mouth and your chin.<br/>" +
                        "   √ Do not touch the mask while you are wearing it for protection.<br/>" +
                        "   √ After use, take off the mask with clean hands; remove the elastic loops from behind the ears while keeping the mask away from your face and clothes, to avoid touching potentially contaminated surfaces of the mask.<br/>" +
                        "   √ Discard the mask in a closed bin immediately after use. Do not reuse the mask.<br/>" +
                        "   √ Perform hand hygiene after touching or discarding the mask – Use alcohol-based hand rub or, if visibly soiled, wash your hands with soap and water.<br/>" +
                        "♦ Be aware that there is a global shortage of medical masks (both surgical masks and N95 masks). These should be reserved as much as possible for health care workers."+
                        "</ul>" ;

                if(linearLayout16.getVisibility()==View.GONE)
                {
                    textView16.setText(Html.fromHtml(htmlString));
                    linearLayout16.setVisibility(View.VISIBLE);
                    imageButton16.setBackgroundResource(R.drawable.hide_block);
                }
                else {
                    linearLayout16.setVisibility(View.GONE);
                    imageButton16.setBackgroundResource(R.drawable.display_block);
                }
                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }
    }

}