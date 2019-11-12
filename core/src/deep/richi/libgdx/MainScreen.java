package deep.richi.libgdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Align;

import deep.richi.libgdx.rtl.RtlController;
import deep.richi.libgdx.rtl.RtlFreeTypeFontGenerator;


/***
 * @author Richi on 10/28/20.
 */
public class MainScreen extends BaseScreen {

    private static final String EINSTEIN_TEXT = "اگر نتوانی چیزی را به سادگی برای کسی توضیح دهی، خودت هم آن چیز را به خوبی درک نکرده ای.\n (اینشتین)";
    private static final String WRAP_FULL_TEST_SEQUENCE = "فرمول آب H@2O است! آموزش زبان انگلیسی، مثل Hi, How are you آسان است. منظومه شمسی 1 خورشید دارد که (زمین) به دور آن 365 روز و 5.6 ساعت {طول} میکشد دور آن بچرخد.";
    private BitmapFont rtlBitmapFont;
    public MainScreen() {
        BitmapFont rtlBitmapFont = this.createRtlBitmapFont();
    }
    @Override
    public void show() {
        super.show();


        Label einsteinLabel = new Label(EINSTEIN_TEXT, new Label.LabelStyle(rtlBitmapFont, Color.GOLD));
        einsteinLabel.setWrap(true);
        einsteinLabel.setWidth(900);
        einsteinLabel.setX(50);
        einsteinLabel.setY(600);
        stage.addActor(einsteinLabel);



        Label fullTestLabel = new Label(WRAP_FULL_TEST_SEQUENCE, new Label.LabelStyle(rtlBitmapFont, Color.WHITE));
        fullTestLabel.setWrap(true);
        fullTestLabel.setWidth(550);
        fullTestLabel.setX(200);
        fullTestLabel.setY(300);
        stage.addActor(fullTestLabel);



        TextArea.TextFieldStyle style = new TextField.TextFieldStyle();
        style.font = rtlBitmapFont;
        style.fontColor = Color.YELLOW;
        TextField textField = new TextField("تکست فیلد", style);
        textField.setDebug(true); // showing debug lines
        textField.setSize(500, 80);
        textField.setAlignment(Align.right);
        textField.setPosition(20, 20);
        stage.addActor(textField);

    }
    private BitmapFont createRtlBitmapFont() {
        RtlFreeTypeFontGenerator generator = new RtlFreeTypeFontGenerator(Gdx.files.internal("fonts/Sarbaz.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.characters += RtlController.getInstance().getAllRtlChars();
        param.size = 40;
        param.color = Color.WHITE;
        param.borderColor = Color.RED;
        param.borderStraight = true;
        param.borderWidth = 1f;
        param.shadowColor = Color.DARK_GRAY;
        param.shadowOffsetX = +5;
        param.shadowOffsetY = +5;
        param.minFilter = Texture.TextureFilter.Nearest;
        param.magFilter = Texture.TextureFilter.Nearest;
        return generator.generateRtlFont(param);
    }
}