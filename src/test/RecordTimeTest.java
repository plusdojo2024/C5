package test;

import java.util.List;

import dao.RecordsDAO;
import model.RecordTime;

public class RecordTimeTest {

	public static void main(String[] args) {
	RecordsDAO dao = new RecordsDAO();
	List<RecordTime> cardList;
	cardList = dao.select(new RecordTime());


	for (RecordTime card : cardList) {
		System.out.print(card.getTime() + ",");
		System.out.print(card.getWork() + ",");
		System.out.print(card.getMilk_quantity() + ",");
		System.out.println(card.getComment());

	}

	}

}
