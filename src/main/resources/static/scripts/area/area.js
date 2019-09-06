var Area = function () {

    var _DataAPi = new Object(1);
    // 地区
    _DataAPi.areaListSelect = "selectAreaList.json";

    /**
     * 初始化 Bootstrap Select插件
     * @param dom
     * @private
     */
    var _initBootstrapSelect = function (dom) {
        if (!dom) {
            dom = ".bs-select";
        }
        jQuery(dom).selectpicker({
            iconBase: 'fa',
            tickIcon: 'fa-check'
        });
        jQuery(dom).selectpicker('refresh');
    };

    /**
     * 表单地区
     * @private
     */
    var _initFromArea = function(dom) {
        areaSelect = dom ?dom :'fromArea';
        var _selectHtml="<select class=\"bs-select\" name=\""+areaSelect+"\" data-live-search=\"true\" onchange=\"Area.areaFromChange(this,'"+areaSelect+"');\">";
        var _areaArray=[];
        var areaHidden = jQuery("#"+areaSelect).val();
        if (areaHidden != null && areaHidden != '') {
            _areaArray=areaHidden.split(",");
        }
        var _optionHtml = "<option></option>";
        jQuery.ajax({
            type: 'POST',
            url: _DataAPi.areaListSelect,
            dataType: "json",
            cache: false,
            async: false,//
            data: {
                "level": 0
            },
            success: function (pdata) {
                jQuery.each(pdata, function (idx, item) {
                    _optionHtml += "<option value=\"" + item.code + "\" >" + item.value + "</option>";
                });
                _selectHtml+=_optionHtml;
                _selectHtml+="</select>";
                jQuery("#"+areaSelect).after(_selectHtml);
                var $fromArea=jQuery("#"+areaSelect).next();

                _initBootstrapSelect();

                if(_areaArray.length!=0){
                    $fromArea.val(_areaArray[0]).change();
                }

                for (var i=1;i<_areaArray.length;i++){
                    $fromArea.parent("div").siblings().eq(i).find("select").val(_areaArray[i]).change();
                }
            }
        });
    };

    /**
     * 地区Change
     */
    var _areaFromChange = function (obj,areaSelect) {
        var changeObj = jQuery(obj).clone();
        changeObj.empty();
        var index=jQuery(obj).parent("div").index();
        jQuery(obj).parent("div").css("margin-right","5px");
        var areaId=jQuery(obj).val();
        var value="";
        if(areaId==""){
            jQuery(obj).parent("div").nextAll().remove();
            jQuery("select[name='"+areaSelect+"']").each(function(){
                value+=jQuery(this).val()+",";
            });
            return jQuery("#"+areaSelect).val(value);
        }
        jQuery.ajax({
            type: 'POST',
            url: _DataAPi.areaListSelect,
            async: false,
            dataType: "json",
            data: {
                "areaId": areaId,
                "level": index
            },
            success: function (pdata) {
                var html = "<option></option>";
                jQuery.each(pdata, function (idx, item) {
                    html +=  "<option value=\"" + item.code + "\" >" + item.value + "</option>";
                });
                changeObj.html(html);
                jQuery(obj).parent("div").nextAll().remove();
                if (pdata.length != 0) {
                    jQuery(obj).parent("div").after(changeObj);
                    _initBootstrapSelect();
                }
            }
        });
        jQuery("select[name='"+areaSelect+"']").each(function(){
            value+=jQuery(this).val()+",";
        });
        jQuery("#"+areaSelect).val(value);
    };

    return {
        initFromArea:function (dom) {
            _initFromArea(dom);
        },
        areaFromChange: function (obj,areaSelect) {
            _areaFromChange(obj,areaSelect);
        }
    };
}();