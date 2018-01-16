package com.sherry.ffmpegdemo;

/**
 * 压缩工具类
 *
 * Created by shanxs on 2017/5/27.
 */
public class FfmpegKit {

    static{
        System.loadLibrary("ffmpegDemo");
    }

    private static OnExecListener listener;

    /**
     * 调用底层执行
     * @param argv
     * @return
     */
    public static native int run(String[] argv);

    /**
     * 执行ffmoeg命令
     * @param cmds
     * @param listener
     */
    public static void exec(String[] cmds, OnExecListener listener) {
        FfmpegKit.listener = listener;
        run(cmds);
    }

    public static void onExecuted(int ret) {
        if (listener != null) {
            listener.onExecuted(ret);
        }
    }

    /**
     * 执行完成/错误 时的回调接口
     */
    public interface OnExecListener {
        void onExecuted(int ret);
    }

    public static native String configure();
}
