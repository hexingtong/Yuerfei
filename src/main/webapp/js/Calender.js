/**
 * Created by Administrator on 2019/3/7.
 */

    $('document').ready(function(){
        /*
         * ���ɼ����˵�
         */
        var i=2000;
        var date = new Date();
        year = date.getFullYear();//��ȡ��ǰ���
        var dropList;
        for(i;i<2019;i++){
            if(i == year){
                dropList = dropList + "<option value='"+i+"' selected>"+i+"</option>";
            }else{
                dropList = dropList + "<option value='"+i+"'>"+i+"</option>";
            }
        }
        $('select[name=year]').html(dropList);//������������˵�
        var monthly;
        for(month=1;month<13;month++){
            monthly = monthly + "<option value='"+month+"'>"+month+"</option>";
        }
        $('select[name=month]').html(monthly);//�����·������˵�
        var dayly;
        for(day=1;day<=31;day++){
            dayly = dayly + "<option value='"+day+"'>"+day+"</option>";
        }
        $('select[name=day]').html(dayly);//�������������˵�
        /*
         * ����ÿ�����ж�����---����
         */
        $('select[name=month]').change(function(){
            var currentDay;
            var Flag = $('select[name=year]').val();
            var currentMonth = $('select[name=month]').val();
            switch(currentMonth){
                case "1" :
                case "3" :
                case "5" :
                case "7" :
                case "8" :
                case "10" :
                case "12" :total = 31;break;
                case "4" :
                case "6" :
                case "9" :
                case "11" :total = 30;break;
                case "2" :
                    if((Flag%4 == 0 && Flag%100 != 0) || Flag%400 == 0){
                        total = 29;
                    }else{
                        total = 28;
                    }
                default:break;
            }
            for(day=1;day <= total;day++){
                currentDay = currentDay + "<option value='"+day+"'>"+day+"</option>";
            }
            $('select[name=day]').html(currentDay);//�������������˵�
        })
    })
