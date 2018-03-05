package huawei.biz.impl;

import huawei.biz.CardManager;
import huawei.biz.Conductor;
import huawei.biz.Passenger;
import huawei.biz.SubwayManager;
import huawei.exam.CardEnum;
import huawei.exam.ReturnCodeEnum;
import huawei.exam.SubwayException;
import huawei.model.Card;
import huawei.model.ConsumeRecord;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: 待考生实现类</p>
 *
 * <p>Description: 乘客</p>
 *
 * <p>Copyright: Copyright (c) 2013</p>
 *
 * <p>Company: </p>
 *
 * @author
 * @version 1.0 OperationCenter V100R002C20, 2015/9/7]
 */
public class PassengerImpl implements Passenger
{
    private Conductor conductor;
    private CardManager cardManager;
    private SubwayManager subwayManager;

    public PassengerImpl(Conductor conductor, CardManager cardManager, SubwayManager subwayManager)
    {
        this.conductor = conductor;
        this.cardManager = cardManager;
        this.subwayManager = subwayManager;
    }

    @Override
    public Card buyCard(String enterStation, String exitStation)
        throws SubwayException
    {
        //TODO 待考生实现
    	Card card = new Card();
        return null;
    }

    @Override
    public Card buyCard(CardEnum cardEnum, int money)
        throws SubwayException
    {
        //TODO 待考生实现
    	
    	if (CardManagerImpl.allCards.size() >= CardManagerImpl.maxCards)
    	{
    		// can not buy card
    		
    	}
    	else
    	{
    		Card card = new Card();
    		String cardId = calCardId();
    		card.setCardId(cardId);
    		int totalMoney = calCardMoney(cardEnum, money);
    		card.setMoney(totalMoney);
    		card.setCardType(cardEnum);
    		
    		CardManagerImpl.allCards.put(cardId, card);
    		CardManagerImpl.allConsumeRecords.put(cardId, new LinkedList<ConsumeRecord>());
    		
    		return card;
    	}
    	
    }
    
    // 计算该票id
    public String calCardId() 
    {
    	String cardId = null;
    	for (int i = 0; i < CardManagerImpl.maxCards; i ++)
		{			
			if (!CardManagerImpl.allCards.containsKey(String.valueOf(i)))
			{
				cardId = String.valueOf(i);
				break;
			}
			else
			{
				continue;
			}
		}
    	
    	return cardId;
	}
    
    // 计算奖励后的充值金额
    public int calCardMoney(CardEnum cardEnum, int money) {
		int totalMoney = money;
    	switch (cardEnum) {
		case A:
			
			break;
		case B:
			
			break;
		case C:
			
			break;
		case D:
			totalMoney = totalMoney + totalMoney / 50 * 10;
			break;
		case E:
			
			break;
		default:
			break;
		}
    	
    	return totalMoney;
	}

    @Override
    public Card recharge(String cardId, int money)
        throws SubwayException
    {
        //TODO 待考生实现
        return null;
    }

    @Override
    public Card queryCard(String cardId) throws SubwayException
    {
        //TODO 待考生实现
        return null;
    }

    @Override
    public Card deleteCard(String cardId)
        throws SubwayException
    {
        //TODO 待考生实现
        return null;
    }

    @Override
    public Card takeSubway(String cardId, String enterStation, String enterTime, String exitStation, String exitTime)
        throws SubwayException
    {
        //TODO 待考生实现
        return null;
    }

    @Override
    public List<ConsumeRecord> queryConsumeRecord(String cardId)
        throws SubwayException
    {
        //TODO 待考生实现
        return null;
    }
}