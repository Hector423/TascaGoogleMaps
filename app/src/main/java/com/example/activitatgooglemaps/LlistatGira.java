package com.example.activitatgooglemaps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class LlistatGira extends AppCompatActivity {

    private HashMap<String, String> llistatXML = new HashMap<>();
    private RecyclerView recyclerView;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ImageView imageView;
    private ArrayAdapter<String> lAdapter;
    private List<String> paisos = new LinkedList<>();
    private List<String> localitat = new LinkedList<>();
    private List<String> escenari = new LinkedList<>();
    private List<String> data = new LinkedList<>();
    private List<String> link = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_llistat);
        List<String> items = new LinkedList<>();

        try {
            InputStream input = getAssets().open("concerts.xml");
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(input);
            NodeList nList = doc.getElementsByTagName("concert");
            
            for(int i = 0; i< nList.getLength(); i++){
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){

                    paisos.add(node.getChildNodes().item(1).getTextContent());
                    localitat.add(node.getChildNodes().item(3).getTextContent());
                    escenari.add(node.getChildNodes().item(5).getTextContent());

                    recyclerView = findViewById(R.id.listadoConcierto);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    DistribucioLlistat distribucioLlistat = new DistribucioLlistat(paisos, localitat, escenari);
                    recyclerView.setAdapter(distribucioLlistat);
                    distribucioLlistat.notifyItemInserted(paisos.size()-1);
                }
            }
        }catch (
                IOException e) {
            e.printStackTrace();
        } catch (
                ParserConfigurationException e) {
            e.printStackTrace();
        } catch (
                SAXException e) {
            e.printStackTrace();
        }
    }
}