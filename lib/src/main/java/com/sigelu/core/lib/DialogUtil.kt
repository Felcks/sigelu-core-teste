package com.sigelu.core.lib

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.support.annotation.StringRes
import android.view.View

import android.support.design.widget.Snackbar


class DialogUtil {

    companion object {

        /**
         * Cria uma caixa de texto na tela
         *
         * @param activity onde o diálogo sera plotado
         * @param tituloId texto de título
         * @param mensagemId texto da mensagem
         * @param positiveButtonTextId texto do botão positivo (a direita)
         * @param positiveButtonAcao função chamada caso o usuário aperte positivo
         * @param negativeButtonTextId texto do botão negativo (a esquerda)
         * @param negativeButtonAcao função chamada caso o usuário aperte negativo
         * @param cancelavel torna a caixa cancelável ou não
         */
        fun buildAlertDialog(
                        activity: Activity,
                        @StringRes
                        tituloId: Int,
                        @StringRes
                        mensagemId: Int,
                        @StringRes
                        positiveButtonTextId: Int,
                        positiveButtonAcao: () -> Unit,
                        negativeButtonTextId: Int,
                        negativeButtonAcao: () -> Unit,
                        cancelavel: Boolean = false): AlertDialog{

            val positiveButtonOnClickListener = DialogInterface.OnClickListener { dialog, which -> positiveButtonAcao() }
            val negativeButtonClickListener = DialogInterface.OnClickListener { dialog, which ->  negativeButtonAcao() }

            val alertDialogBuilder = AlertDialog.Builder(activity)
            alertDialogBuilder.setTitle(tituloId)
            alertDialogBuilder.setMessage(mensagemId)
            alertDialogBuilder.setPositiveButton(positiveButtonTextId, positiveButtonOnClickListener)
            alertDialogBuilder.setNegativeButton(negativeButtonTextId, negativeButtonClickListener)
            alertDialogBuilder.setCancelable(cancelavel)

            return alertDialogBuilder.create()
        }

        fun showSnackbar(
                view: View,
                @StringRes
                messageId: Int){

            val snackbar = Snackbar.make(view, messageId, Snackbar.LENGTH_LONG)
            snackbar.show()
        }
    }

}