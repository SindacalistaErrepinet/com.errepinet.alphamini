package com.errepinet.alphamini.skills;

import android.util.Log;

import com.ubtechinc.skill.ProxySkill;
import com.ubtechinc.skill.SkillType;
import com.ubtrobot.master.annotation.Call;
import com.ubtrobot.master.skill.SkillStopCause;
import com.ubtrobot.mini.sysevent.event.base.KeyEvent;
import com.ubtrobot.speech.protos.Speech;
import com.ubtrobot.transport.message.Request;
import com.ubtrobot.transport.message.Responder;

/**
 * author：龙仲春
 * email:zhongchun.long@ubtrobot.com
 * date：2020-02-17 17:31
 * package：com.ubtrobot.mini.sdkdemo.skills
 * project：mini_libs_robot_sdk
 */
public class UnInterruptibleSkill extends ProxySkill {

    private static final String TAG = "UnInterruptibleSkill";

    @Override
    protected void onSkillStart() {
        super.onSkillStart();
        Log.d(TAG, "不可打断技能启动 ");
    }

    @Override
    protected void onSkillStop(SkillStopCause skillStopCause) {
        super.onSkillStop(skillStopCause);
        Log.d(TAG, "不可打断技能停止："+skillStopCause);
    }

    @Call(path = "/demo_uninterruptible/startSkill")
    public void onStartSkill(Request request, final Responder responder){
        Log.d(TAG,"onStartSkill---");
        responder.respondSuccess();
    }

    @Override
    protected String getSkillName() {
        return "demo_uninterruptible_skill";
    }

    @Override
    protected SkillType getSkillType() {
        return SkillType.Uninterruptible;
    }

    @Override
    protected SkillType getSubSkillType() {
        return null;
    }

    @Override
    protected boolean onHeadTapEvent(KeyEvent keyEvent) {
        stopSkill();
        return true;
    }

    @Override
    protected void onWakeUpEvent(Speech.WakeupParam wakeupParam) {

    }

    @Override
    protected boolean isNeedWakeUpEvent() {
        return false;
    }

    @Override
    protected boolean isNeedHeadTapEvent() {
        return true;
    }
}
