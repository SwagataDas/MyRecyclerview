package com.example.debjit.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {
    private String[] textList = {"Orange", "Strawberry", "Guava", "Lichi", "Mango", "Peach"};
    private String[] descriptionList = {"Description of the Orange Fruit.", "The garden strawberry is a widely grown hybrid species of the genus Fragaria.", "Guavas are rich in dietary fiber and vitamin C.", "Lychee in the soapberry family, Sapindaceae.", "Mangoes are juicy stone fruit from numerous species of tropical trees belonging to the flowering plant genus Mangifera.", "Though fuzzy peaches and nectarines are regarded commercially as different fruits." };
    private int[] imageList = {R.drawable.orange, R.drawable.strawberry, R.drawable.guava, R.drawable.lichi, R.drawable.mango, R.drawable.peach};
    private ArrayList<ModuleActivity> moduleActivities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addItemsToArrayList();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyRecyclerAdapter(moduleActivities));
    }

    private void addItemsToArrayList() {
        moduleActivities.add(new ModuleActivity(R.drawable.orange, "Orange"));
        moduleActivities.add(new ModuleActivity(R.drawable.strawberry, "Strawberry"));
        moduleActivities.add(new ModuleActivity(R.drawable.guava, "Guava"));
        moduleActivities.add(new ModuleActivity(R.drawable.lichi, "Lichi"));
        moduleActivities.add(new ModuleActivity(R.drawable.mango, "Mango"));
        moduleActivities.add(new ModuleActivity(R.drawable.peach, "Peach"));
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

        //the array list initiated via constructor
        private final ArrayList<ModuleActivity> moduleActivities;

        //the constructor
        public MyRecyclerAdapter(ArrayList<ModuleActivity> moduleActivities) {
            this.moduleActivities = moduleActivities;
        }



        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final ImageView imageView;
            final TextView textView;
            final TextView textView1;
            final View view;
            //inflate for new view
            View rootView = getLayoutInflater().inflate(R.layout.activity_module, parent, false);
            imageView = rootView.findViewById(R.id.imageview_child_id);
            textView = rootView.findViewById(R.id.textview_child_id);
            textView1 = rootView.findViewById(R.id.textview_child_id2);
            view = rootView;
            return new MyViewHolder(rootView);              //return the view holder object to be used in the onBindViewHolder method
        }
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            //get the corresponding student pojo object for a given position
            ModuleActivity moduleActivity = moduleActivities.get(position);
            //update views values
            holder.textView.setText(moduleActivity.getText());
            holder.imageView.setImageResource(moduleActivity.getImage());
        }
        @Override
        public int getItemCount() {
            return moduleActivities.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;
        private final TextView textView1;
        private final View view;


        public MyViewHolder(View rootView) {
            super(rootView);
            imageView = rootView.findViewById(R.id.imageview_child_id);
            textView = rootView.findViewById(R.id.textview_child_id);
            textView1 = rootView.findViewById(R.id.textview_child_id2);
            view = rootView;
        }
    }
}
