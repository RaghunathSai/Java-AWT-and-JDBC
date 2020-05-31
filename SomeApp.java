

public class Consumer implements Runnable
{
    public Consumer()
    {
        Thread consumer = new Thread(this);
        consumer.start();
    }

    public void run()
    {
        while(true)
        {
            //get an object off the queue
            Object object = QueueHandler.dequeue();
            //do some stuff with the object
        }
    }
}


public class Producer implements Runnable
{
    public Producer()
    {
        Thread producer = new Thread(this);
        producer.start();
    }

    public void run()
    {
        while(true)
        {
            //add to the queue some sort of unique object
            QueueHandler.enqueue(new Object());
        }
    }
}


public class QueueHandler
{
    //This Queue class is a thread safe (written in house) class
    public static Queue<Object> readQ = new Queue<Object>(100);

    public static void enqueue(Object object)
    {
        //do some stuff
        readQ.add(object);
    }

    public static Object dequeue()
    {
        //do some stuff
        return readQ.get();
    }
}

public class SomeApp
{
    private Consumer consumer;
    private Producer producer;

    public static void main (String args[])
    {
        consumer = new Consumer();
        producer = new Producer();
    }
} 
