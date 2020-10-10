function goToDownload() {
    CheckPage.action="getDownloadList.do";
    CheckPage.submit();
}

function returnBack() {
    window.history.back(-1);
}