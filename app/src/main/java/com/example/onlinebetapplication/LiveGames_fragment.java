package com.example.onlinebetapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlinebetapplication.Repository.Game_Repository;
import com.example.onlinebetapplication.Repository.SaveGameList;
import com.example.onlinebetapplication.adapter.OnlineBetAdapter;
import com.example.onlinebetapplication.game_properties.Root;
import com.example.onlinebetapplication.model.User_Information;
import com.example.onlinebetapplication.util.User_Information_View_Model;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LiveGames_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LiveGames_fragment extends Fragment {
    private RecyclerView recyclerView;
    public LiveGames_fragment() {
        // Required empty public constructor
    }

    public static LiveGames_fragment newInstance() {
        LiveGames_fragment fragment = new LiveGames_fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("User_id livegames", String.valueOf(this.getArguments().getLong("user_information")));
        long user_id = this.getArguments().getLong("user_information");
        User_Information_View_Model user_information_view_model = new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()).create(User_Information_View_Model.class);
        user_information_view_model.get(user_id).observe(this, new Observer<User_Information>() {
            @Override
            public void onChanged(User_Information user_information) {
                new Game_Repository().getAllGames("https://api.the-odds-api.com/v4/sports/upcoming/odds/?regions=uk&markets=h2h&apiKey=473d0d8228911e2755747e54eee3f943", new SaveGameList() {
                    @Override
                    public void getGameList(List<Root> gameList) {
                        OnlineBetAdapter onlineBetAdapter = new OnlineBetAdapter(gameList, user_id, requireActivity().getApplication(), user_information);
                        recyclerView.setAdapter(onlineBetAdapter);
                    }
                });
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live_games, container, false);
        recyclerView = view.findViewById(R.id.gameLIST);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        // Inflate the layout for this fragment
        return view;
    }
}