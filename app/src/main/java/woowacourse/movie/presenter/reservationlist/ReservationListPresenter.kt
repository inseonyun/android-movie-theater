package woowacourse.movie.presenter.reservationlist

import woowacourse.movie.contract.reservationlist.ReservationListContract
import woowacourse.movie.ui.entity.Reservations
import woowacourse.movie.ui.model.MovieTicketModel

class ReservationListPresenter(private val view: ReservationListContract.View) :
    ReservationListContract.Presenter {
    private lateinit var reservations: List<MovieTicketModel>
    private var itemSize = 0

    override fun setupReservations(movieTickets: List<MovieTicketModel>) {
        this.reservations = movieTickets
    }

    override fun loadReservations() {
        view.setReservationView(reservations)
    }

    override fun setItemsInsertion() {
        val diffSize = Reservations.getSize() - itemSize
        if (diffSize > 0) {
            view.updateReservationViewItem(itemSize, diffSize)
            itemSize = Reservations.getSize()
        }
    }
}
