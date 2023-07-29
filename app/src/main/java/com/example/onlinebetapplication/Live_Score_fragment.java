package com.example.onlinebetapplication;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.onlinebetapplication.Repository.Live_Game_Repository;
import com.example.onlinebetapplication.Repository.SaveLiveGameList;
import com.example.onlinebetapplication.adapter.OnlineGameAdapter;
import com.example.onlinebetapplication.livegame_properties.Root1;

import java.util.ArrayList;
import java.util.List;

public class Live_Score_fragment extends Fragment {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private CardView search_card;
    private RecyclerView recyclerView;
    private TextView league_name;
    private SearchView searchLeagues;
    private List<String> leagues;
    public Live_Score_fragment() {
        // Required empty public constructor
    }
    public static Live_Score_fragment newInstance() {
        Live_Score_fragment fragment = new Live_Score_fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live__score_fragment, container, false);
        search_card = view.findViewById(R.id.crd_search1);
        league_name = view.findViewById(R.id.leagueName_id);
        recyclerView = view.findViewById(R.id.score_board);
        listView = view.findViewById(R.id.league_list_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setHasFixedSize(true);
        searchLeagues = view.findViewById(R.id.search_leagues);
        leagues = new ArrayList<>();
        leagues.add("NCAAF");
        leagues.add("NFL");
        leagues.add("AFL");
        leagues.add("MLB");
        leagues.add("NBA");
        leagues.add("WNBA");
        leagues.add("NCAAB");
        leagues.add("NHL");
        leagues.add("NRL");
        leagues.add("Primera División - Argentina");
        leagues.add("A-League");
        leagues.add("Austrian Football Bundesliga");
        leagues.add("Belgium First Div");
        leagues.add("Brazil Série A");
        leagues.add("Brazil Série B");
        leagues.add("Primera División - Chile");
        leagues.add("Super League - China");
        leagues.add("Denmark Superliga");
        leagues.add("Championship");
        leagues.add("EFL Cup");
        leagues.add("League 1");
        leagues.add("League 2");
        leagues.add("EPL");
        leagues.add("FA Cup");
        leagues.add("FIFA World Cup");
        leagues.add("Veikkausliiga - Finland");
        leagues.add("Ligue 1 - France");
        leagues.add("Ligue 2 - France");
        leagues.add("Bundesliga - Germany");
        leagues.add("Bundesliga 2 - Germany");
        leagues.add("3. Liga - Germany");
        leagues.add("Super League - Greece");
        leagues.add("Serie A - Italy");
        leagues.add("Serie B - Italy");
        leagues.add("Japan League");
        leagues.add("Korea League 1");
        leagues.add("League of Ireland");
        leagues.add("Liga Mexico");
        leagues.add("Dutch Eredivisie");
        leagues.add("Eliteserien - Norway");
        leagues.add("Ekstraklasa - Poland");
        leagues.add("Primeira Liga - Portugal");
        leagues.add("Premier League - Russia");
        leagues.add("La Liga - Spain");
        leagues.add("La Liga 2 - Spain");
        leagues.add("Premiership - Scotland");
        leagues.add("Allsvenskan - Sweden");
        leagues.add("Superettan - Sweden");
        leagues.add("Swiss Superleague");
        leagues.add("Turkey Super League");
        leagues.add("UEFA Champions League");
        leagues.add("UEFA Europa League");
        leagues.add("MLS");
        adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1,leagues);
        listView.setAdapter(adapter);


        List<String> list1 = new ArrayList<>();
        final int[] cnt1 = {1};
        final String[] sportKey = {"soccer_usa_mls"};
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(cnt1[0] == 1){
                    switch (leagues.get(position)){
                        case "NCAAF":
                            sportKey[0] = "americanfootball_ncaaf";
                            break;
                        case "NFL":
                            sportKey[0] = "americanfootball_nfl";
                            break;
                        case "AFL":
                            sportKey[0] = "aussierules_afl";
                            break;
                        case "MLB":
                            sportKey[0] = "baseball_mlb";
                            break;
                        case "NBA":
                            sportKey[0] = "basketball_nba";
                            break;
                        case "WNBA":
                            sportKey[0] = "basketball_wnba";
                            break;
                        case "NCAAB":
                            sportKey[0] = "basketball_ncaab";
                            break;
                        case "NHL":
                            sportKey[0] = "icehockey_nhl";
                            break;
                        case "NRL":
                            sportKey[0] = "rugbyleague_nrl";
                            break;
                        case "Primera División - Argentina":
                            sportKey[0] = "soccer_argentina_primera_division";
                            break;
                        case "A-League":
                            sportKey[0] = "soccer_australia_aleague";
                            break;
                        case "Austrian Football Bundesliga":
                            sportKey[0] = "soccer_austria_bundesliga";
                            break;
                        case "Belgium First Div":
                            sportKey[0] = "soccer_belgium_first_div";
                            break;
                        case "Brazil Série A":
                            sportKey[0] = "soccer_brazil_campeonato";
                            break;
                        case "Brazil Série B":
                            sportKey[0] = "soccer_brazil_serie_b";
                            break;
                        case "Primera División - Chile":
                            sportKey[0] = "soccer_chile_campeonato";
                            break;
                        case "Super League - China":
                            sportKey[0] = "soccer_china_superleague";
                            break;
                        case "Denmark Superliga":
                            sportKey[0] = "soccer_denmark_superliga";
                            break;
                        case "Championship":
                            sportKey[0] = "soccer_efl_champ";
                            break;
                        case "EFL Cup":
                            sportKey[0] = "soccer_england_efl_cup";
                            break;
                        case "FA Cup":
                            sportKey[0] = "soccer_fa_cup";
                            break;
                        case "League 1":
                            sportKey[0] = "soccer_england_league1";
                            break;
                        case "League 2":
                            sportKey[0] = "soccer_england_league2";
                            break;
                        case "EPL":
                            sportKey[0] = "soccer_epl";
                            break;
                        case "FIFA World Cup":
                            sportKey[0] = "soccer_fifa_world_cup";
                            break;
                        case "Veikkausliiga - Finland":
                            sportKey[0] = "soccer_finland_veikkausliiga";
                            break;
                        case "Ligue 1 - France":
                            sportKey[0] = "soccer_france_ligue_one";
                            break;
                        case "Ligue 2 - France":
                            sportKey[0] = "soccer_france_ligue_two";
                            break;
                        case "Bundesliga - Germany":
                            sportKey[0] = "soccer_germany_bundesliga";
                            break;
                        case "Bundesliga 2 - Germany":
                            sportKey[0] = "soccer_germany_bundesliga2";
                            break;
                        case "3. Liga - Germany":
                            sportKey[0] = "soccer_germany_liga3";
                            break;
                        case "Super League - Greece":
                            sportKey[0] = "soccer_greece_super_league";
                            break;
                        case "Japan League":
                            sportKey[0] = "soccer_japan_j_league";
                            break;
                        case "Serie A - Italy":
                            sportKey[0] = "soccer_italy_serie_a";
                            break;
                        case "Serie B - Italy":
                            sportKey[0] = "soccer_italy_serie_b";
                            break;
                        case "Korea League 1":
                            sportKey[0] = "soccer_korea_kleague1";
                            break;
                        case "League of Ireland":
                            sportKey[0] = "soccer_league_of_ireland";
                            break;
                        case "Liga Mexico":
                            sportKey[0] = "soccer_mexico_ligamx";
                            break;
                        case "Dutch Eredivisie":
                            sportKey[0] = "soccer_netherlands_eredivisie";
                            break;
                        case "Eliteserien - Norway":
                            sportKey[0] = "soccer_norway_eliteserien";
                            break;
                        case "Ekstraklasa - Poland":
                            sportKey[0] = "soccer_poland_ekstraklasa";
                            break;
                        case "Primeira Liga - Portugal":
                            sportKey[0] = "soccer_portugal_primeira_liga";
                            break;
                        case "Premier League - Russia":
                            sportKey[0] = "soccer_russia_premier_league";
                            break;
                        case "La Liga - Spain":
                            sportKey[0] = "soccer_spain_la_liga";
                            break;
                        case "La Liga 2 - Spain":
                            sportKey[0] = "soccer_spain_segunda_division";
                            break;
                        case "Premiership - Scotland":
                            sportKey[0] = "soccer_spl";
                            break;
                        case "Allsvenskan - Sweden":
                            sportKey[0] = "soccer_sweden_allsvenskan";
                            break;
                        case "Superettan - Sweden":
                            sportKey[0] = "soccer_sweden_superettan";
                            break;
                        case "Swiss Superleague":
                            sportKey[0] = "soccer_switzerland_superleague";
                            break;
                        case "Turkey Super League":
                            sportKey[0] = "soccer_turkey_super_league";
                            break;
                        case "UEFA Champions League":
                            sportKey[0] = "soccer_uefa_champs_league";
                            break;
                        case "UEFA Europa League":
                            sportKey[0] = "soccer_uefa_europa_league";
                            break;
                        case "MLS":
                            sportKey[0] = "soccer_usa_mls";
                            break;
                    }
                }
                else{
                    switch (list1.get(position)){
                        case "NCAAF":
                            sportKey[0] = "americanfootball_ncaaf";
                            break;
                        case "NFL":
                            sportKey[0] = "americanfootball_nfl";
                            break;
                        case "AFL":
                            sportKey[0] = "aussierules_afl";
                            break;
                        case "MLB":
                            sportKey[0] = "baseball_mlb";
                            break;
                        case "NBA":
                            sportKey[0] = "basketball_nba";
                            break;
                        case "WNBA":
                            sportKey[0] = "basketball_wnba";
                            break;
                        case "NCAAB":
                            sportKey[0] = "basketball_ncaab";
                            break;
                        case "NHL":
                            sportKey[0] = "icehockey_nhl";
                            break;
                        case "NRL":
                            sportKey[0] = "rugbyleague_nrl";
                            break;
                        case "Primera División - Argentina":
                            sportKey[0] = "soccer_argentina_primera_division";
                            break;
                        case "A-League":
                            sportKey[0] = "soccer_australia_aleague";
                            break;
                        case "Austrian Football Bundesliga":
                            sportKey[0] = "soccer_austria_bundesliga";
                            break;
                        case "Belgium First Div":
                            sportKey[0] = "soccer_belgium_first_div";
                            break;
                        case "Brazil Série A":
                            sportKey[0] = "soccer_brazil_campeonato";
                            break;
                        case "Brazil Série B":
                            sportKey[0] = "soccer_brazil_serie_b";
                            break;
                        case "Primera División - Chile":
                            sportKey[0] = "soccer_chile_campeonato";
                            break;
                        case "Super League - China":
                            sportKey[0] = "soccer_china_superleague";
                            break;
                        case "Denmark Superliga":
                            sportKey[0] = "soccer_denmark_superliga";
                            break;
                        case "Championship":
                            sportKey[0] = "soccer_efl_champ";
                            break;
                        case "EFL Cup":
                            sportKey[0] = "soccer_england_efl_cup";
                            break;
                        case "FA Cup":
                            sportKey[0] = "soccer_fa_cup";
                            break;
                        case "League 1":
                            sportKey[0] = "soccer_england_league1";
                            break;
                        case "League 2":
                            sportKey[0] = "soccer_england_league2";
                            break;
                        case "EPL":
                            sportKey[0] = "soccer_epl";
                            break;
                        case "FIFA World Cup":
                            sportKey[0] = "soccer_fifa_world_cup";
                            break;
                        case "Veikkausliiga - Finland":
                            sportKey[0] = "soccer_finland_veikkausliiga";
                            break;
                        case "Ligue 1 - France":
                            sportKey[0] = "soccer_france_ligue_one";
                            break;
                        case "Ligue 2 - France":
                            sportKey[0] = "soccer_france_ligue_two";
                            break;
                        case "Bundesliga - Germany":
                            sportKey[0] = "soccer_germany_bundesliga";
                            break;
                        case "Bundesliga 2 - Germany":
                            sportKey[0] = "soccer_germany_bundesliga2";
                            break;
                        case "3. Liga - Germany":
                            sportKey[0] = "soccer_germany_liga3";
                            break;
                        case "Super League - Greece":
                            sportKey[0] = "soccer_greece_super_league";
                            break;
                        case "Japan League":
                            sportKey[0] = "soccer_japan_j_league";
                            break;
                        case "Serie A - Italy":
                            sportKey[0] = "soccer_italy_serie_a";
                            break;
                        case "Serie B - Italy":
                            sportKey[0] = "soccer_italy_serie_b";
                            break;
                        case "Korea League 1":
                            sportKey[0] = "soccer_korea_kleague1";
                            break;
                        case "League of Ireland":
                            sportKey[0] = "soccer_league_of_ireland";
                            break;
                        case "Liga Mexico":
                            sportKey[0] = "soccer_mexico_ligamx";
                            break;
                        case "Dutch Eredivisie":
                            sportKey[0] = "soccer_netherlands_eredivisie";
                            break;
                        case "Eliteserien - Norway":
                            sportKey[0] = "soccer_norway_eliteserien";
                            break;
                        case "Ekstraklasa - Poland":
                            sportKey[0] = "soccer_poland_ekstraklasa";
                            break;
                        case "Primeira Liga - Portugal":
                            sportKey[0] = "soccer_portugal_primeira_liga";
                            break;
                        case "Premier League - Russia":
                            sportKey[0] = "soccer_russia_premier_league";
                            break;
                        case "La Liga - Spain":
                            sportKey[0] = "soccer_spain_la_liga";
                            break;
                        case "La Liga 2 - Spain":
                            sportKey[0] = "soccer_spain_segunda_division";
                            break;
                        case "Premiership - Scotland":
                            sportKey[0] = "soccer_spl";
                            break;
                        case "Allsvenskan - Sweden":
                            sportKey[0] = "soccer_sweden_allsvenskan";
                            break;
                        case "Superettan - Sweden":
                            sportKey[0] = "soccer_sweden_superettan";
                            break;
                        case "Swiss Superleague":
                            sportKey[0] = "soccer_switzerland_superleague";
                            break;
                        case "Turkey Super League":
                            sportKey[0] = "soccer_turkey_super_league";
                            break;
                        case "UEFA Champions League":
                            sportKey[0] = "soccer_uefa_champs_league";
                            break;
                        case "UEFA Europa League":
                            sportKey[0] = "soccer_uefa_europa_league";
                            break;
                        case "MLS":
                            sportKey[0] = "soccer_usa_mls";
                            break;
                    }
                }
                new Live_Game_Repository().getAllLiveGames("https://api.the-odds-api.com/v4/sports/" + sportKey[0] + "/scores/?daysFrom=3&apiKey=e1f628b0aba2dc7871ad729d4c4003b5", new SaveLiveGameList() {
                    @Override
                    public void getLiveGameList(List<Root1> allLiveGames) {
                        league_name.setText(allLiveGames.get(0).getSportTitle());
                        OnlineGameAdapter onlineGameAdapter = new OnlineGameAdapter(allLiveGames);
                        recyclerView.setAdapter(onlineGameAdapter);

                    }
                });
            }
        });

        searchLeagues.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                for (int i = 0; i < leagues.size(); i++) {
                    if(leagues.get(i).toLowerCase().startsWith(newText.toLowerCase())){
                        if(!list1.contains(leagues.get(i))){
                            list1.add(leagues.get(i));
                        }
                    }
                    else if(list1.contains(leagues.get(i))){
                        list1.remove(leagues.get(i));
                    }
                }
                if(newText.length() == 0){
                    if(cnt1[0] == 0){
                        ++cnt1[0];
                    }
                    adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1,leagues);

                }
                else {
                    if(cnt1[0] == 1){
                        --cnt1[0];
                    }
                    adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, list1);
                }
                listView.setAdapter(adapter);
                return false;
            }
        });

        searchLeagues.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.gravity = Gravity.CENTER | Gravity.TOP;
                int margin = 5;
                float density = getResources().getDisplayMetrics().density;
                layoutParams.topMargin = (int) (margin * density);
                search_card.setLayoutParams(layoutParams);
                league_name.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
            }
        });
        searchLeagues.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                list1.clear();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.gravity = Gravity.TOP | Gravity.RIGHT;
                int margin = 5;
                float density = getResources().getDisplayMetrics().density;
                layoutParams.topMargin = (int) (margin * density);
                search_card.setLayoutParams(layoutParams);
                league_name.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                return false;
            }
        });
        new Live_Game_Repository().getAllLiveGames("https://api.the-odds-api.com/v4/sports/" + sportKey[0] + "/scores/?daysFrom=3&apiKey=e1f628b0aba2dc7871ad729d4c4003b5", new SaveLiveGameList() {
            @Override
            public void getLiveGameList(List<Root1> allLiveGames) {
                league_name.setText(allLiveGames.get(0).getSportTitle());
                OnlineGameAdapter onlineGameAdapter = new OnlineGameAdapter(allLiveGames);
                recyclerView.setAdapter(onlineGameAdapter);

            }
        });
        return view;
    }

}