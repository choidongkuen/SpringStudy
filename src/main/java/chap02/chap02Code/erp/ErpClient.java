package chap02.chap02Code.erp;

public interface ErpClient {

	public void connect();

	public void close();

	public void sendPurchaseInfo(ErpOrderData oi);
}
