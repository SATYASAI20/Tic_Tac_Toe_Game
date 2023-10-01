package com.example.tictoctoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tictoctoe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private final List<int[]> combinationList = new ArrayList<>();
    private int[] boxPositions ={0,0,0,0,0,0,0,0,0};
    private  int playerTurn =1;
    private int totalSelectedBoxes=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        combinationList.add(new int[]{0,1,2});
        combinationList.add(new int[]{3,4,5});
        combinationList.add(new int[]{6,7,8});
        combinationList.add(new int[]{0,3,6});
        combinationList.add(new int[]{2,5,8});
        combinationList.add(new int[]{1,4,7});
        combinationList.add(new int[]{2,4,6});
        combinationList.add(new int[]{0,4,8});

        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        binding.playerOneName.setText(getPlayerOneName);
        binding.playerTwoName.setText(getPlayerTwoName);

        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(0)){
                    performAction((ImageView)v,0);
                }
            }
        });
        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(1)){
                    performAction((ImageView)v,1);
                }
            }
        });
        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(2)){
                    performAction((ImageView)v,2);
                }
            }
        });
        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(3)){
                    performAction((ImageView)v,3);
                }
            }
        });
        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(4)){
                    performAction((ImageView)v,4);
                }
            }
        });
        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(5)){
                    performAction((ImageView)v,5);
                }
            }
        });
        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(6)){
                    performAction((ImageView)v,6);
                }
            }
        });
        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(7)){
                    performAction((ImageView)v,7);
                }
            }
        });
        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelected(8)){
                    performAction((ImageView)v,8);
                }
            }
        });

    }

    private void performAction(ImageView imageView, int selectedBoxPosition){
        boxPositions[selectedBoxPosition] = playerTurn;

        if(playerTurn==1){
            imageView.setImageResource(R.drawable.x_image);
//            imageView.setImageResource(R.drawable.o_image);
            if(checkResult()){
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, binding.playerOneName.getText().toString()+" is a winnner!", this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else if (totalSelectedBoxes ==9){
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "Match Draw", this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else{
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }

        }else{
            imageView.setImageResource(R.drawable.o_image);
            if(checkResult()){
                ResultDialog resultDialog = new ResultDialog(MainActivity.this , binding.playerTwoName.getText().toString()+" is a winner!", this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else if (totalSelectedBoxes ==9){
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "Match Draw", this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else{
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;
        if(playerTurn == 1){
            binding.playerOneLayout.setBackgroundResource(R.drawable.black_border);
            binding.PlayerTwoLayout.setBackgroundResource(R.drawable.white_box);

        }else{
            binding.PlayerTwoLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_box);

        }
    }

    private boolean checkResult(){
        boolean response = false;
        for(int i=0;i<combinationList.size();i++){
            final int[] combination = combinationList.get(i);
            if(boxPositions[combination[0]]==playerTurn && boxPositions[combination[1]]==playerTurn && boxPositions[combination[2]]==playerTurn){
                response =true;
            }
        }
        return response;
    }

    private  boolean isBoxSelected(int boxPosition){
        boolean response = boxPositions[boxPosition] == 0;
        return response;
    }

    public void restartMatch(){
        boxPositions = new int[] {0,0,0,0,0,0,0,0,0};
        playerTurn =1;
        totalSelectedBoxes =1;

        binding.image1.setImageResource(R.drawable.white_box);
        binding.image2.setImageResource(R.drawable.white_box);
        binding.image3.setImageResource(R.drawable.white_box);
        binding.image4.setImageResource(R.drawable.white_box);
        binding.image5.setImageResource(R.drawable.white_box);
        binding.image6.setImageResource(R.drawable.white_box);
        binding.image7.setImageResource(R.drawable.white_box);
        binding.image8.setImageResource(R.drawable.white_box);
        binding.image9.setImageResource(R.drawable.white_box);

    }
}