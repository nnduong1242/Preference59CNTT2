package vn.edu.ntu.nguyennamduong.preference59cntt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String sharePrefName = "my_share_preference";
    public static final String key_ten = "ten";
    public static final String key_ngay_sinh = "ngay_sinh";
    public static final String key_nam = "nam";
    public static final String key_nu = "nu";
    public static final String key_sdt = "so_dien_thoai";

    EditText edtTen, edtNgaySinh, edtSDT;
    RadioButton rdbNam, rdbNu;
    Button btnLuu, btnDoc, btnXoa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        docPref();
    }

    private void addViews(){
        edtTen = findViewById(R.id.edtTen);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        edtSDT = findViewById(R.id.edtSDT);
        rdbNam = findViewById(R.id.rbdNam);
        rdbNu = findViewById(R.id.rdbNu);
        btnLuu = findViewById(R.id.btnLuu);
        btnDoc = findViewById(R.id.btnDoc);
        btnXoa = findViewById(R.id.btnXoa);

        btnLuu.setOnClickListener(this);
        btnDoc.setOnClickListener(this);
        btnXoa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnLuu: luuPref(); break;
            case R.id.btnDoc: docPref(); break;
            case R.id.btnXoa: xoaGiaoDien(); break;
        }
    }
    private  void luuPref(){
        SharedPreferences sharedPreferences = getSharedPreferences(sharePrefName, MODE_PRIVATE);
        if (sharedPreferences != null){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(key_ten, edtTen.getText().toString());
            editor.putString(key_ngay_sinh, edtNgaySinh.getText().toString());
            editor.putBoolean(key_nam, rdbNam.isChecked());
            editor.putBoolean(key_nu, rdbNu.isChecked());
            editor.putString(key_sdt, edtSDT.getText().toString());
            editor.commit();
        }
    }

    private  void docPref(){
        SharedPreferences sharedPreferences = getSharedPreferences(sharePrefName, MODE_PRIVATE);
        if (sharedPreferences != null){
            String ten = sharedPreferences.getString(key_ten, "Chưa có tên");
            String ngaySinh = sharedPreferences.getString(key_ngay_sinh, "Chưa sinh ra");
            Boolean nam = sharedPreferences.getBoolean(key_nam, true);
            Boolean nu = sharedPreferences.getBoolean(key_nu, false);
            String sdt = sharedPreferences.getString(key_sdt, "Chưa mua điện thoại");
            edtTen.setText(ten);
            edtNgaySinh.setText(ngaySinh);
            edtSDT.setText(sdt);
            rdbNam.setChecked(nam);
            rdbNam.setChecked(nu);
        }
    }

    private  void xoaGiaoDien(){
        edtTen.setText("");
        edtNgaySinh.setText("");
        edtSDT.setText("");
        rdbNam.setChecked(true);
        rdbNam.setChecked(false);
    }
}
