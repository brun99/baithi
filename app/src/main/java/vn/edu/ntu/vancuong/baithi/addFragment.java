package vn.edu.ntu.vancuong.baithi;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;

import vn.edu.ntu.vancuong.baithi.controller.IController;
import vn.edu.ntu.vancuong.baithi.model.ThongTin;

public class addFragment extends Fragment {

    private Toolbar mTbadd;
    private EditText mEdtmh;
    private EditText mEdtnbd;
    private ImageView mImgnbd;
    private EditText mEdtndk;
    private ImageView mImgndk;
    private EditText mEdtgd;
    private Spinner mSpnht;
    private Button mBtnthem;
    private Button mBtnxemds;

    IController controller;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        setHasOptionsMenu(true);
        addview(view);
        addevent();
        return view;

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.my_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void addevent() {
        mTbadd.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_addFragment_to_danhsachFragment);
            }
        });

        mImgnbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                final DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(year).append("/")
                                .append(month+1).append("/")
                                .append(dayOfMonth);
                        mEdtnbd.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),listener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        mImgndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                final DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(year).append("/")
                                .append(month+1).append("/")
                                .append(dayOfMonth);
                        mEdtndk.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),listener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        mBtnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThongTin thongTin = new ThongTin(mEdtmh.getText().toString(), mEdtnbd.getText().toString(), mEdtndk.getText().toString()
                , mEdtgd.getText().toString(),mSpnht.getSelectedItem().toString());
                controller.add(thongTin);
                Toast.makeText(getActivity(),"đã thêm",Toast.LENGTH_SHORT).show();
            }
        });

        mBtnxemds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_addFragment_to_danhsachFragment);
            }

        });
    }

    private void addview(View view) {
        mTbadd = view.findViewById(R.id.tbadd);
        mEdtmh = view.findViewById(R.id.edtmh);
        mEdtnbd = view.findViewById(R.id.edtnbd);
        mImgnbd = view.findViewById(R.id.imgnbd);
        mEdtndk = view.findViewById(R.id.edtndk);
        mImgndk = view.findViewById(R.id.imgndk);
        mEdtgd = view.findViewById(R.id.edtgd);
        mSpnht = view.findViewById(R.id.spnht);
        mBtnthem = view.findViewById(R.id.btnthem);
        mBtnxemds = view.findViewById(R.id.btnxemds);

        controller = ((MainActivity)getActivity()).controller;
        navController = NavHostFragment.findNavController(addFragment.this);

        ((MainActivity)getActivity()).setSupportActionBar(mTbadd);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        mTbadd.setNavigationIcon(R.drawable.ic_action_back);

        String[] hinhthuc = new String[]{"Học online","Trực tiếp","khóa học web"}; // Khai báo 1 mảng dữ liệu cho spinner

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(addFragment.this.getActivity(),
                R.layout.support_simple_spinner_dropdown_item,hinhthuc);
        mSpnht.setAdapter(arrayAdapter);
    }
}