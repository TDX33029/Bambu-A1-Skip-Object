package com.bambulab.bambulab.common.device.data.api;

import com.bambulab.bambulab.model.IotTaskData;
import com.bambulab.bambulab.model.PrintHistoryModel;
import com.bambulab.bambulab.model.PrintedIndex;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import defpackage.bbn;
import defpackage.pxk;
import defpackage.rf7;
import defpackage.tqd;
import io.sentry.ProfilingTraceData;
import io.sentry.protocol.Device;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\u000e\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u0007H§@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0010\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0012\u0010\u0006¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/bambulab/bambulab/common/device/data/api/DeviceTaskDetailApi;", "", "", "id", "Lcom/bambulab/bambulab/model/PrintHistoryModel;", "getPrintTaskInfo", "(JLrf7;)Ljava/lang/Object;", "", "taskId", "Lcom/bambulab/bambulab/model/IotTaskData;", "getIotTask", "(Ljava/lang/String;Lrf7;)Ljava/lang/Object;", "profileId", "modelId", "getProfileInfo", "(Ljava/lang/String;Ljava/lang/String;Lrf7;)Ljava/lang/Object;", "instanceId", "Lcom/bambulab/bambulab/model/PrintedIndex;", "getTaskPrintedPlates", "data"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DeviceTaskDetailApi {
    @tqd("iot-service/api/user/task/{task_id}")
    Object getIotTask(@pxk(PushConstants.TASK_ID) String r1, rf7<? super IotTaskData> r2);

    @tqd("user-service/my/task/{id}")
    Object getPrintTaskInfo(@pxk("id") long r1, rf7<? super PrintHistoryModel> r3);

    @tqd("iot-service/api/user/profile/{profile_id}")
    Object getProfileInfo(@pxk(ProfilingTraceData.JsonKeys.PROFILE_ID) String r1, @bbn(Device.JsonKeys.MODEL_ID) String r2, rf7<? super IotTaskData> r3);

    @tqd("user-service/my/task/printedplates")
    Object getTaskPrintedPlates(@bbn("instanceId") long r1, rf7<? super PrintedIndex> r3);
}
