package jsc.exam.jsckit.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import jsc.exam.jsckit.adapter.ClassItemAdapter;
import jsc.exam.jsckit.entity.ClassItem;
import jsc.exam.jsckit.ui.zxing.ZXingQRCodeActivity;
import jsc.kit.swiperecyclerview.OnItemClickListener;
import jsc.lib.zxinglibrary.zxing.ui.ZXingFragment;

public class MainActivity extends ABaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setContentView(recyclerView);

        ClassItemAdapter adapter = new ClassItemAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener<ClassItem>() {
            @Override
            public void onItemClick(View view, ClassItem item) {
                startActivity(new Intent(view.getContext(), item.getCls()));
            }

            @Override
            public void onItemClick(View view, ClassItem item, int adapterPosition, int layoutPosition) {

            }
        });
        adapter.setItems(getClassItems());
    }

    private List<ClassItem> getClassItems(){
        List<ClassItem> classItems = new ArrayList<>();
        classItems.add(new ClassItem("ComponentList", ComponentListActivity.class));
        classItems.add(new ClassItem("ZXingQRCode", ZXingQRCodeActivity.class));
        classItems.add(new ClassItem("Retrofit2", Retrofit2Activity.class));
        classItems.add(new ClassItem("DateTimePicker", DateTimePickerActivity.class));
        classItems.add(new ClassItem("AboutActivity", AboutActivity.class));
        return classItems;
    }
}
