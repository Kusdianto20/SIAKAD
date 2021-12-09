package com.project01.siakad1.ui.tugas

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.project01.siakad1.MainActivity
import com.project01.siakad1.R
import com.project01.siakad1.ui.keuangan.KeuanganActivity
import kotlinx.android.synthetic.main.activity_detail_tugas.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class DetailTugasActivity : AppCompatActivity() {

    private var fileUri: Uri? = null
    private var mediaPath: String? = null
    private var mImageFileLocation = ""
    private var postPath: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tugas)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Tugas"

        btn_download_file.setOnClickListener{
            Toast.makeText(this, "File Tidak ada", Toast.LENGTH_SHORT).show()
        }

        buttonProcess.setOnClickListener{

            AlertDialog.Builder(this).setTitle(getString(R.string.kirimTugas))
                .setPositiveButton(getString(R.string.yes)){ialog, _ ->

                    val kirimTugasActivity = Intent(this, TugasActivity::class.java)
                    startActivity(kirimTugasActivity)
                    Toast.makeText(this, "Anda Telah Mengerjakan Tugas!", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(getString(R.string.no)){dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
            )
        }

        camBtn.setOnClickListener {
            captureImage()
        }

        chooseBtn.setOnClickListener {
            val galleryIntent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(galleryIntent, REQUEST_PICK_PHOTO)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val REQUEST_CODE_PERMISSIONS = 10
        val REQUIRED_PERMISSIONS = arrayOf(
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
        //resouce variable for camera feature and make file
        const val REQUEST_TAKE_PHOTO = 0
        const val REQUEST_PICK_PHOTO = 2
        const val CAMERA_PIC_REQUEST = 1111
        const val MEDIA_TYPE_IMAGE = 1

        private val TAG = MainActivity::class.java.simpleName
        private const val IMAGE_DIRECTORY_NAME = "Android File Upload"

        private fun getOutputMediaFile(type: Int): File? {
            val mediaStorageDir = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), IMAGE_DIRECTORY_NAME
            )
            if (!mediaStorageDir.exists()) {
                if (!mediaStorageDir.mkdirs()) {
                    Log.d(
                        TAG, "Oops! Failed create "
                                + IMAGE_DIRECTORY_NAME + " directory")
                    return null
                }
            }
            SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val mediaFile: File
            if (type == MEDIA_TYPE_IMAGE) {
                mediaFile = File(
                    mediaStorageDir.path + File.separator
                            + "IMG_" + ".jpg")
            } else {
                return null
            }
            return mediaFile
        }
    }
    //for  ask permission
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }
    // on activity result usefull when user has done with action take camera or choose from gallery
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_TAKE_PHOTO || requestCode == REQUEST_PICK_PHOTO) {
            if (data != null) {
                val selectedImage = data.data
                val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
                val cursor = applicationContext?.contentResolver?.query(
                    selectedImage!!,
                    filePathColumn,
                    null,
                    null,
                    null
                )
                assert(cursor != null)
                cursor!!.moveToFirst()

                val columnIndex = cursor.getColumnIndex(filePathColumn[0])
                mediaPath = cursor.getString(columnIndex)
                imageAnalitics.setImageBitmap(BitmapFactory.decodeFile(mediaPath))
                cursor.close()
                postPath = mediaPath
            }
        } else if (requestCode == CAMERA_PIC_REQUEST) {
            postPath = if (Build.VERSION.SDK_INT > 21) {
                Glide.with(this).load(mImageFileLocation).into(imageAnalitics)
                mImageFileLocation
            } else {
                Glide.with(this).load(fileUri).into(imageAnalitics)
                fileUri!!.path
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    @Throws(IOException::class)
    internal fun createImageFile(): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmSS").format(Date())
        val imageFileName = "IMAGE_" + timeStamp
        val storageDirectory =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + "/photo_saving_app")
        if (!storageDirectory.exists()) storageDirectory.mkdir()
        val image = File(storageDirectory, "$imageFileName.jpg")
        mImageFileLocation = image.absolutePath
        return image
    }

    private fun captureImage() {
        if (Build.VERSION.SDK_INT > 21) {
            val callCameraApplicationIntent = Intent()
            callCameraApplicationIntent.action = MediaStore.ACTION_IMAGE_CAPTURE

            var photoFile: File? = null
            try {
                photoFile = createImageFile()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            val outputUri = FileProvider.getUriForFile(
                this,
                "com.project01.siakad1" + ".provider",
                photoFile!!
            )
            callCameraApplicationIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri)
            callCameraApplicationIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivityForResult(callCameraApplicationIntent, CAMERA_PIC_REQUEST)
        } else {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
            startActivityForResult(intent, CAMERA_PIC_REQUEST)
        }
    }

    private fun getOutputMediaFileUri(type: Int): Uri {
        return Uri.fromFile(getOutputMediaFile(type))
    }
}