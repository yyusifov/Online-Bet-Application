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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.onlinebetapplication.adapter.BetSaverAdapter;
import com.example.onlinebetapplication.data.UserWithBets;
import com.example.onlinebetapplication.model.User_Information;
import com.example.onlinebetapplication.util.User_Information_View_Model;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link User_Bets_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class User_Bets_fragment extends Fragment {
    private RecyclerView recyclerView;
    private EditText betMoney;
    private Button betButton;
    private TextView amount_that_can_be_earned;
    public User_Bets_fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static User_Bets_fragment newInstance() {
        User_Bets_fragment fragment = new User_Bets_fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int user_id = this.getArguments().getInt("user information1");
        User_Information_View_Model user_information_view_model = new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()).create(User_Information_View_Model.class);
        user_information_view_model.getUserWithBets().observe(getActivity(), new Observer<List<UserWithBets>>() {
            @Override
            public void onChanged(List<UserWithBets> userWithBets) {
                BetSaverAdapter betSaverAdapter = new BetSaverAdapter(userWithBets, user_id);
                recyclerView.setAdapter(betSaverAdapter);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user__bets_fragment, container, false);
        betButton = view.findViewById(R.id.bet_button);
        amount_that_can_be_earned = view.findViewById(R.id.possible_amount);
        betMoney = view.findViewById(R.id.betAmount);
        recyclerView = view.findViewById(R.id.recycler_view2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        int user_id = this.getArguments().getInt("user information1");
        int user_id2 = (int)this.getArguments().getLong("user_information");
        Log.d("Memoloy", String.valueOf(user_id2));

        User_Information_View_Model user_information_view_model = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(User_Information_View_Model.class);
        final int[] cnt2 = {0};
        user_information_view_model.getUserWithBets().observe(requireActivity(), new Observer<List<UserWithBets>>() {
            @Override
            public void onChanged(List<UserWithBets> userWithBets) {

                Log.d("My nigga", (userWithBets.get(user_id).user.getBet_money() != 0.0) + " " + (userWithBets.get(user_id).user_bets.size() > 0));
                if(userWithBets.get(user_id).user.getBet_money() != 0.0 && userWithBets.get(user_id).user_bets.size() > 0){
                    betMoney.setText(String.valueOf(userWithBets.get(user_id).user.getBet_money()));
                    amount_that_can_be_earned.setText(String.valueOf(userWithBets.get(user_id).user.getBet_amount()) + "$");
                    betMoney.setEnabled(false);
                    betButton.setVisibility(View.GONE);
                    if(cnt2[0] == 1){
                        cnt2[0]--;
                    }
                }
                else if(cnt2[0] == 0){
                    cnt2[0]++;
                    Log.d("Heyhey", "Wsssup man");
                    User_Information user_information = userWithBets.get(user_id).user;
                    user_information.setBet_money(0.0);
                    user_information.setBet_amount(0.0);
                    User_Information_View_Model.update(user_information);
                    betMoney.getText().clear();
                    betMoney.setEnabled(true);
                    betButton.setVisibility(View.VISIBLE);
                    amount_that_can_be_earned.setText("0.0$");
                }
            }
        });
        if(betMoney.getText().toString().isEmpty()) {
            betButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final int[] cnt = {0};
                    if (betMoney.getText().toString().isEmpty()) {
                        Snackbar.make(betButton, "You have to add certain amount of money on the bet!", Snackbar.LENGTH_LONG).show();
                        amount_that_can_be_earned.setText("0$");
                    }
                    else {
                        final double[] total_amount = {1.0};
                        User_Information_View_Model user_information_view_model = new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()).create(User_Information_View_Model.class);
                        user_information_view_model.getUserWithBets().observe(getActivity(), new Observer<List<UserWithBets>>() {
                            @Override
                            public void onChanged(List<UserWithBets> userWithBets) {//ilk defede bet atmaq olmur
                                if(userWithBets.get(user_id).user.getBalance() - Double.valueOf(betMoney.getText().toString()) >= 0) {
                                    if (cnt[0] == 0) {
                                        if (userWithBets.get(user_id).user_bets.size() > 0 && !betMoney.getText().toString().isEmpty()) {
                                            for (int i = 0; i < userWithBets.get(user_id).user_bets.size(); i++) {
                                                total_amount[0] *= userWithBets.get(user_id).user_bets.get(i).getPrice() * 1.0;
                                            }
                                            total_amount[0] *= Double.valueOf(betMoney.getText().toString()) * 1.0;
                                            amount_that_can_be_earned.setText(String.valueOf(total_amount[0]) + "$");
                                            User_Information user_information = userWithBets.get(user_id).user;
                                            user_information.setBet_money(Double.valueOf(betMoney.getText().toString()));
                                            user_information.setBalance(userWithBets.get(user_id).user.getBalance() - Double.valueOf(betMoney.getText().toString()));
                                            user_information.setBet_amount(total_amount[0]);
                                            User_Information_View_Model.update(user_information);
                                            cnt[0]++;
                                            betMoney.setEnabled(false);
                                            betButton.setVisibility(View.GONE);
                                        } else {
                                            amount_that_can_be_earned.setText("0.0$");
                                            betMoney.getText().clear();
                                            betMoney.setEnabled(true);
                                            betButton.setVisibility(View.VISIBLE);
                                        }
                                    }
                                }
                                else{
                                    Snackbar.make(betMoney, "You do not have enough money to make a bet. Please, increase your balance", Snackbar.LENGTH_SHORT).show();
                                }
                            }
                        });
                        betMoney.setEnabled(false);
                        betButton.setVisibility(View.GONE);
                    }
                }
            });
        }
        return view;
    }
}