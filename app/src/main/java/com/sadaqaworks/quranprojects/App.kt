package com.sadaqaworks.quranprojects

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log

import com.sadaqaworks.quranprojects.util.settings.Config


/**
 * Created by Sadmansamee on 7/27/15.
 */
class App : Application() {
    val config = Config()
    lateinit internal var sharedPreferences: SharedPreferences
//    private val loadedFont = "1"
//    private val loadedFontSize = "1"

    override fun onCreate() {
        super.onCreate()
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        app = this
        config.load(this)
        Log.e("app ", "onCreate")
        //loadFont();
    }

    companion object {
        lateinit var app: App
    }

    //    public boolean loadFont() {
    //        if (!loadedFont.equals(config.fontArabic) || !loadedFontSize.equals(config.fontSizeArabic)) {
    //
    //            try {
    //
    //                Log.e("App: config.fontArabic", loadedFont + " " + config.fontArabic + " size: " + loadedFontSize + config.fontSizeArabic);
    //                NativeRenderer.loadFont(this.getResources().getAssets().open(config.fontArabic));
    //                FontCache.getInstance().clearCache();
    //                loadedFont = config.fontArabic;
    //                loadedFontSize = config.fontSizeArabic;
    //            } catch (IOException e) {
    //                Log.e("app", "LoadFont Failed");
    //                e.printStackTrace();
    //                loadedFont = "1";
    //                loadedFontSize = "1";
    //                return false;
    //            }
    //        }
    //        Log.e("app", "LoadFont");
    //        return true;
    //    }
}
