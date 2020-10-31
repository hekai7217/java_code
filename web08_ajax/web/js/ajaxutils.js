
/**
 *
 * 把ajax的操作进行封装
 *   思路:
 *    01 把ajax的重复的代码进行抽取
 *    02 把不确定的参数 通过 方法传入进来
 *       method,url,async 通过参数传递过来
 *
 *    03 get/post 发送数据不一样,判断 method 分别处理get和post
 *
 *         get,   参数在url上进行拼接
 *         post,  需要发送头信息, 参数需要单独的发送
 *       参数问题:
 *         如果是get 参数在url上拼接  封装的时候 params 必须是"k1=v1&k2=v2" 键值对
 *
 *    04 传入一个请求成功的执行的函数
 *
 * */
/**
 *
 * @param methodStr   请求方法
 * @param url         请求的url
 * @param async       是否异步 boolean
 * @param params      请求的参数
 * @param success     请求执行的函数
 */
function ajax(methodStr,url,async,params,success){

    // 01 创建 发送数据的ajax, XmlHttpRequest
    var xhr = new XMLHttpRequest();
    // 02  监听 XmlHttpRequest 的状态
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200){
            // alert(xhr.responseText);
            success(xhr.responseText); // 请求成功执行的函数
        }
    }
    // 03  初始化 XmlHttpRequest
    // 把 请求方法转成小写 判断
    if (methodStr.toLowerCase() == "get"){
        // ajax的 get请求 参数在url上拼接
        ///web08/ajax02?name=scott&pwd=tiger
        // url + ? + k1=v1&k2=v2
        var geturl = url + "?" + params;
        console.log(geturl);
        xhr.open(methodStr,geturl,async);
        // 04  发送请求
        xhr.send();
    }

    if (methodStr.toLowerCase() == "post"){
        // ajax的 get请求 参数在url上拼接
        xhr.open(methodStr,url,async);

        xhr.setRequestHeader("Content-Type",
            "application/x-www-form-urlencoded")
        // 04  发送请求
        xhr.send(params);
    }

}