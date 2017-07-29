package apandatv.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import apandatv.app.App;
import butterknife.ButterKnife;

/**
 * activity基类
 * Created by lenovo on 2017/7/27.
 */

public abstract class BaseActivity extends AppCompatActivity {

    //记录上一个显示的Fragment
    private BaseFragment lastFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.context = this;
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        init();
    }

    protected abstract int getLayoutId();
    protected abstract void init();

//   切换Fragment
    public BaseFragment changeFragment(Class<? extends BaseFragment> fragmentClass,int containId,boolean isHidden,Bundle bundle,boolean isBack) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        String fragmentName = fragmentClass.getSimpleName();
        BaseFragment nowFragment = (BaseFragment) manager.findFragmentByTag(fragmentName);
        if(nowFragment == null){
            try {
                //通过Java动态代理创建的对象
                nowFragment = fragmentClass.newInstance();
                //添加到FragmentManager中
                transaction.add(containId,nowFragment,fragmentName);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //判断fragment是否隐藏
        if(isHidden) {

            if (lastFragment != null)
                //隐藏显示
                transaction.hide(lastFragment);
                transaction.show(nowFragment);
        }else {

            //替换
            transaction.replace(containId,nowFragment,fragmentName);
        }
        //传递参数
        if(bundle != null){
            nowFragment.setBundle(bundle);
        }

        if(isBack){
            transaction.addToBackStack(fragmentName);
        }

        transaction.commit();

        lastFragment = nowFragment;

        return lastFragment;

    }
}
