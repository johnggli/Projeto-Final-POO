package app.john.com.listanime.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import app.john.com.listanime.R;
import app.john.com.listanime.intermediario.Controle;
import app.john.com.listanime.modelos.Anime;

public class MeusNumeros extends AppCompatActivity {

    List<Anime> animes;
    float assistindo, concluidos, pretendoAssistir, descartados;

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_numeros);

        Controle controle = new Controle();

        animes = new ArrayList<>();
        animes.addAll(controle.getUsuarioLogado().getAnimes());

        carregarDados();

        int colorPrimaryDark = Color.parseColor("#2f2f2f");

        Description descricao = new Description();
        descricao.setText("");

        pieChart = findViewById(R.id.grafico);

        pieChart.setRotationEnabled(true);
        pieChart.setCenterText("Total: " + animes.size());
        pieChart.setCenterTextSize(24);
        pieChart.setCenterTextColor(Color.WHITE);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setEntryLabelColor(Color.WHITE);
        pieChart.setEntryLabelTextSize(16);
        pieChart.setDescription(descricao);
        pieChart.setHoleRadius(50f);
        pieChart.setHoleColor(colorPrimaryDark);

        adicionarDados();
    }

    private void carregarDados() {
        for (Anime anime: animes) {
            switch (anime.getStatus()) {
                case "Assistindo":
                    assistindo++;
                    break;
                case "Concluído":
                    concluidos++;
                    break;
                case "Pretendo assistir":
                    pretendoAssistir++;
                    break;
                case "Descartado":
                    descartados++;
                    break;
            }
        }
    }

    private void adicionarDados() {
        List<PieEntry> entries = new ArrayList<>();
        List<Integer> cores = new ArrayList<>();

        if (assistindo > 0) {
            entries.add(new PieEntry(assistindo, "Assistindo"));
            cores.add(Color.GREEN);
        }
        if (concluidos > 0) {
            entries.add(new PieEntry(concluidos, "Concluídos"));
            cores.add(Color.BLUE);
        }
        if (pretendoAssistir > 0) {
            entries.add(new PieEntry(pretendoAssistir, "Pretendo Assistir"));
            cores.add(Color.GRAY);
        }
        if (descartados > 0) {
            entries.add(new PieEntry(descartados, "Descartados"));
            cores.add(Color.RED);
        }

        PieDataSet pieDataSet = new PieDataSet(entries, "");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(16);
        pieDataSet.setValueTextColor(Color.BLACK);

        pieDataSet.setColors(cores);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}
