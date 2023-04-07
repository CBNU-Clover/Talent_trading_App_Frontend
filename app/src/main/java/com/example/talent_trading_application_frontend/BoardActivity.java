package com.example.talent_trading_application_frontend;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> dataSet = new ArrayList<>();
        dataSet.add("Item 1");
        dataSet.add("Item 2");
        dataSet.add("Item 3");

        MyAdapter adapter = new MyAdapter(dataSet);
        recyclerView.setAdapter(adapter);
    }
}
