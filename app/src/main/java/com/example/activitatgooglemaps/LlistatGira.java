package com.example.activitatgooglemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class LlistatGira extends AppCompatActivity {

    private ListView listView;
    private HashMap<String, String> llistatXML = new HashMap<>(10);
    private ArrayList<String> arrayList = new ArrayList<>();
    private ImageView imageView;
    private ArrayAdapter<String> lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_llistat);

        listView = findViewById(R.id.listadoConcierto);
        imageView = findViewById(R.id.imagenListado);
        try {
            InputStream input = getAssets().open("concerts.xml");
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(input);
            NodeList nList = doc.getElementsByTagName("concert");

            for(int i = 0; i< nList.getLength(); i++){
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    llistatXML.put("Apais", node.getChildNodes().item(1).getTextContent());
                    llistatXML.put("Blocalitat", node.getChildNodes().item(3).getTextContent());
                    llistatXML.put("Cescenari", node.getChildNodes().item(5).getTextContent());
                    llistatXML.put("DlinkEntrades", node.getChildNodes().item(7).getTextContent());
                    arrayList.addAll(llistatXML.values());

                }
            }
            lAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
            listView.setAdapter(lAdapter);
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


    }




}