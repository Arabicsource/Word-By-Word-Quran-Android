package com.sadaqaworks.quranprojects.util.settings

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log

/**
 * Created by Sadmansamee on 7/25/15.
 */
class Config {

    // public String lang;
    var rtl: Boolean = false
    var showTranslation: Boolean = false
    var wordByWord: Boolean = false
    var fullWidth: Boolean = false
    var keepScreenOn: Boolean = false
    var enableAnalytics: Boolean = false
    var fontArabic: String? = null
    var fontSizeArabic: String? = null
    var fontSizeTranslation: Int = 0


    fun load(context: Context) {
        Log.d("Config", "Load")
        val sp = PreferenceManager.getDefaultSharedPreferences(context)
        try {
            loadDefault()
            fontArabic = sp.getString(Config.ARABIC_FONT, Config.defaultArabicFont)
            fontSizeArabic = sp.getString(Config.FONT_SIZE_ARABIC, Config.defaultFontSizeArabic)
            Log.d("Config", "Loading Custom")

        } catch (e: Exception) {
            loadDefault()
            Log.d("Config", "Exception Loading Defaults")
        }

    }

    fun loadDefault() {
        fontArabic = defaultArabicFont
        fontSizeArabic = defaultFontSizeArabic

    }

    /*public void save(Context context) {
        Log.d("Config","Save");
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.clear();
        ed.putString(LANG, lang);
        ed.putBoolean(SHOW_TRANSLATION, showTranslation);
        ed.putBoolean(WORD_BY_WORD, wordByWord);
        ed.putBoolean(KEEP_SCREEN_ON, keepScreenOn);
        ed.putString(FONT_SIZE_ARABIC, "" + fontSizeArabic);
        ed.putString(FONT_SIZE_TRANSLATION, "" + fontSizeTranslation);
        ed.commit();
    }*/
    private fun getStringInt(sp: SharedPreferences, key: String, defValue: Int): Int {
        return Integer.parseInt(sp.getString(key, Integer.toString(defValue)))
    }

    companion object {

        val FONT_QALAM_MAJEED = 0
        val FONT_HAFS = 1
        val FONT_NOOREHUDA = 2
        val FONT_ME_QURAN = 3
        val FONT_MAX = 3

        val LANG = "lang"
        val LANG_BN = "bn"
        val LANG_EN = "en"
        val LANG_INDO = "indo"
        val SHOW_TRANSLATION = "showTranslation"
        val WORD_BY_WORD = "wordByWord"
        val KEEP_SCREEN_ON = "keepScreenOn"
        val ARABIC_FONT = "arabicFont"
        val FONT_SIZE_ARABIC = "fontSizeArabic"
        val FONT_SIZE_TRANSLATION = "fontSizeTranslation"
        val FIRST_RUN = "firstRun"
        val DATABASE_VERSION = "dbVersion"

        val defaultLang = "en"
        val defaultShowTranslation = true
        val defaultWordByWord = true
        val defaultKeepScreenOn = true
        val defaultArabicFont = "PDMS_IslamicFont.ttf"
        val defaultFontSizeArabic = "30"
        val defaultFontSizeTranslation = "14"
    }

    /*  public boolean loadFont() {
        if (loadedFont != Config.fontArabic) {
            String name;
            switch (config.fontArabic) {
                case Config.FONT_NASKH:
                    name = "naskh.otf";
                    break;
                case Config.FONT_NOOREHUDA:
                    name = "noorehuda.ttf";
                    break;
                case Config.FONT_ME_QURAN:
                    name = "me_quran.ttf";
                    break;
                default:
                    name = "qalam.ttf";
            }
            try {
                NativeRenderer.loadFont(getAssets().open(name));
                loadedFont = config.fontArabic;
            } catch (IOException e) {
                e.printStackTrace();
                loadedFont = -1;
                return false;
            }
        }
        return true;
    }*/


}
