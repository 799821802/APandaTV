package apandatv.ui.module.mine.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import apandatv.base.BaseActivity;
import apandatv.utils.ACache;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/2.
 */

public class PersonalinformationActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.person_information_image)
    ImageView personInformationImage;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.img_touxiang)
    ImageView imgTouxiang;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.tv_nickname)
    TextView tvNickname;
    @BindView(R.id.bt_quit_login)
    Button btQuitLogin;
    private PopupWindow popupWindow;
    private Button btn_camera;
    private Button btn_album;
    private Button btn_cancel;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_personalinformation;
    }

    @Override
    protected void init() {

    }



    @OnClick({R.id.person_information_image, R.id.img, R.id.img_touxiang, R.id.image, R.id.tv_nickname, R.id.bt_quit_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            返回图片
            case R.id.person_information_image:

                break;
            case R.id.img:
                break;
            case R.id.img_touxiang:
                lookimag();
                popwindow();

                break;
            case R.id.image:
                break;
            case R.id.tv_nickname:
                Intent intent=new Intent(PersonalinformationActivity.this,PersonalNickNameActivity.class);
                intent.putExtra("nickname",tvNickname.getText().toString());
                startActivity(intent);
                break;
            case R.id.bt_quit_login:
                ACache aCache=ACache.get(PersonalinformationActivity.this);
                aCache.clear();
                Intent intent2=getIntent();
                setResult(3000,intent2);
                finish();
                break;
        }

    }
private void lookimag(){
    Bitmap bt = BitmapFactory.decodeFile(path + "head.jpg");// 从SD卡中找头像，转换成Bitmap
    if (bt != null) {
        @SuppressWarnings("deprecation")
        Drawable drawable = new BitmapDrawable(bt);// 转换成drawable
        imgTouxiang.setImageDrawable(drawable);
    } else {

        /**
         * 如果SD里面没有则需要从服务器取头像，取回来的头像再保存在SD中
         *
         */

    }
    }
    public void popwindow() {
        popupWindow = new PopupWindow();
        View view = LayoutInflater.from(PersonalinformationActivity.this).inflate(
                R.layout.item_popwindow, null);
        popupWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);// 取得焦点
        //注意  要是点击外部空白处弹框消息  那么必须给弹框设置一个背景色  不然是不起作用的

        ColorDrawable dw = new ColorDrawable(0x30000000);
        popupWindow.setBackgroundDrawable(dw);

        //点击外部消失
        popupWindow.setOutsideTouchable(true);
        //设置可以点击
        popupWindow.setTouchable(true);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);

        btn_camera = (Button) view.findViewById(R.id.btn_camera);
        btn_album = (Button) view.findViewById(R.id.btn_album);
        btn_cancel = (Button) view.findViewById(R.id.btn_cancel);

        btn_camera.setOnClickListener(this);
        btn_album.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_camera:

                // 从本地相册选取图片作为头像
                Intent intent1 = new Intent(Intent.ACTION_PICK, null);
                intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent1, 1);
                popupWindow.dismiss();

                break;
            case R.id.btn_album:

                // 启动手机相机拍摄照片作为头像

                Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent2.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "head.jpg")));
                startActivityForResult(intent2, 2);// 采用ForResult打开
                popupWindow.dismiss();

                break;
            case R.id.btn_cancel:
                popupWindow.dismiss();
                break;
        }
    }
    /**
     * 调用系统的裁剪功能
     *
     * @param uri
     */
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }
    private Bitmap head;// 头像Bitmap

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    cropPhoto(data.getData());// 裁剪图片
                }

                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    File temp = new File(Environment.getExternalStorageDirectory() + "/head.jpg");
                    cropPhoto(Uri.fromFile(temp));// 裁剪图片
                }

                break;
            case 3:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    head = extras.getParcelable("data");
                    if (head != null) {
                        /**
                         * 上传服务器代码
                         */
                        setPicToView(head);// 保存在SD卡中
                        imgTouxiang.setImageBitmap(head);// 用ImageView显示出来
                    }
                }
                break;
            default:
                break;

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private static String path = "/sdcard/myHead/";// sd路径

    private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File(path);
        file.mkdirs();// 创建文件夹
        String fileName = path + "head.jpg";// 图片名字
        try {
            b = new FileOutputStream(fileName);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
