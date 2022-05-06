package android.com.jamsand.io.smack

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_user.*
import kotlin.random.Random

class CreateUserActivity : AppCompatActivity() {
    var userAvatar = "profileDefault" // if user has not selected an avatar
    var avatarColor = "[0.5,0.5,0.5,1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }
    fun generateUserAvatar(view: View){
        val random = java.util.Random()
        val color = random.nextInt(2) // random to 0-1
        val avatar = random.nextInt(28 ) // random to 1-27

        // image color light or dark corresponds to our drawables
        if(color == 0 ){
            userAvatar = "light$avatar"
        } else {
            userAvatar = "dark$avatar"
        }
        val resourceId = resources.getIdentifier(userAvatar,"drawable", packageName)
        createAvatarImageView.setImageResource(resourceId)

    }
    fun generateColorClicked (view: View){
    // construct color from RGB colors and set background color
        val random = Random
        val r = random.nextInt(255)
        val g =random.nextInt(255)
        val b = random.nextInt(255)

        createAvatarImageView.setBackgroundColor(Color.rgb(r,g,b))

        val savedR = r.toDouble()/255
        val savedG = g.toDouble()/255
        val savedB = b.toDouble()/255

        avatarColor = "[$savedR, $savedG, $savedB]"
        println(avatarColor)


    }
    fun createUserClicked (view: View){

    }
}